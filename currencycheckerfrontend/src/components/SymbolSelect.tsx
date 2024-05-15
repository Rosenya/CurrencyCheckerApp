import { useState, useEffect, useCallback } from 'react';
import { Stack, Select, Text, Collapse } from '@chakra-ui/react';
import { Symbol } from '../models/Symbol';
import { SymbolDataApi } from '../api/SymbolDataApi';
import { symbolName } from 'typescript';

const SymbolSelect = () => {
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

  const handleSelectChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    const symbolName: string = event.target.value;
    setSelected(symbolName);
    setIsOpen(true);
  };
  return (
    <Stack spacing={4}>
      <Select
        placeholder="Wybierz symbol"
        value={selected}
        onChange={handleSelectChange}
      >
        {requestGetSymbol.map((symbol: Symbol) => (
          <option key={symbol.id} value={symbol.name}>
            {symbol.name}
          </option>
        ))}
      </Select>
      <Collapse in={isOpen} animateOpacity>
        <Stack spacing={2}>
          <Text>{selected}</Text>
        </Stack>
      </Collapse>
    </Stack>
  );
};

export default SymbolSelect;
