import { useState, useEffect } from 'react';
import { Stack, Select, Text, Collapse } from '@chakra-ui/react';
import { Symbol } from '../models/Symbol';
import { SymbolDataApi } from '../api/SymbolDataApi';

const SymbolPage = () => {
  const [symbols, setSymbols] = useState<Symbol[]>([]);
  const [selectedSymbol, setSelectedSymbol] = useState<string>('');
  const [isOpen, setIsOpen] = useState(false);

  useEffect(() => {
    const fetchSymbols = async () => {
      try {
        const response = await SymbolDataApi.getSymbols();
        setSymbols(response);
      } catch (error) {
        console.error('Błąd podczas pobierania symboli:', error);
        setSymbols([]);
      }
    };

    fetchSymbols();
  }, []);

  const handleSelectChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    const symbolName: string = event.target.value;
    setSelectedSymbol(symbolName);
    setIsOpen(true);
  };

  return (
    <Stack spacing={4}>
      <Select
        placeholder="Wybierz symbol"
        value={selectedSymbol}
        onChange={handleSelectChange}
      >
        {symbols.map((symbol: Symbol) => (
          <option key={symbol.id} value={symbol.name}>
            {symbol.name}
          </option>
        ))}
      </Select>
      <Collapse in={isOpen} animateOpacity>
        <Stack spacing={2}>
          <Text>{selectedSymbol}</Text>
        </Stack>
      </Collapse>
    </Stack>
  );
};

export default SymbolPage;
