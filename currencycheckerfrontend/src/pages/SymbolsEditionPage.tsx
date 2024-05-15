import { Box, Button, Snackbar, TextField, Typography } from "@mui/material";
import React, { useCallback, useEffect, useState } from "react";
import { DataGrid } from '@mui/x-data-grid';
import "./AdminPage.css";
import { symbolName } from "typescript";
import { SymbolDataApi } from "../api/SymbolDataApi";

export const AdminPage = () => {
    const [requestGetSymbol, setRequestGetSymbol] = useState<Symbol[]>([]);
    const [symbol, setSymbol] = useState<Symbol | null>(null);
    const [selected, setSelected] = useState<string>('');
    const [isOpen, setIsOpen] = useState(false);
  
    
      const fetchSymbolsData = useCallback(async () => {
        try{
          const response = await SymbolDataApi.getSymbols();
          setRequestGetSymbol(response.data);
          console.log(symbolName);
        } catch (error){
          console.error(error);
        }
      }, []);
  
  useEffect(() => {
      fetchSymbolsData();
    }, []);
  const handleClose = () => {
    setIsToastOpen(false)
  }

  const onNameChanged = (event: React.ChangeEvent<HTMLInputElement>) => {
    setSymbol({ ...symbol, name: event.currentTarget.value });
  };

  const isNameValid = () => {
    if (!symbol.name) {
      return false;
    }
    return symbol.name.length <= 40;
  };

  const fetchSymbolData = useCallback(async () => {
    try {
      const usages = await SymbolDataApi.getSymbols();
      setRequestGetSymbol(usages.data);
    } catch (error) {
      console.error(error);
    }
  }, []);

  useEffect(() => {
    fetchSymbolsData();
  }, []);

  const postSymbol = async () => {
    try {
      await SymbolDataApi.postSymbol(symbol);
      setIsToastOpen(true)
    } catch (error) {
      console.error(error);
    }
  };

  return (

<div className="wholepage" >
<Box display="flex" flexDirection={"column"} marginX={'32px'} marginY={'32px'} padding={'10px'}  className="symboleditionpage-box" >
<Typography variant="h3" gutterBottom className="title" fontFamily={'Orbitron'}>
Admin Panel
      </Typography>
      <div className="symboleditionpage-textfield">
<TextField

onChange={onNameChanged} 

 label="Add symbol:"
 variant="filled"
 value={symbol.name}
 error={!!symbol.name && !isNameValid()}
 helperText={'Mandatory field!'}
 />

 <Button variant="contained"         onClick={postSymbol}
        disabled={!isNameValid() }>Zatwierdź</Button>
        </div>
        <Snackbar
  open={isToastOpen}
  autoHideDuration={6000}
  onClose={handleClose}
  message="Success"
/>
        <Box mt={"32px"} className="datagrid">
        <DataGrid 
        className="datagrid" 
            rows={requestGetSymbol}
            columns={[{
              field: "name", headerName: "Name", flex: 1/3, sortable: false, editable: false
            },]}
            autoHeight
            pageSize={5}
            disableColumnMenu
            disableSelectionOnClick />
          </Box>
</Box>
</div>
  );
};