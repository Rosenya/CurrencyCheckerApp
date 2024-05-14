import axios from "axios";

export class SymbolDataApi {
  static getSymbols = async (): Promise<Symbol[]> => {
    try {
      const response = await axios.get<Symbol[]>('http://localhost:9000/symbols');
      return response.data;
    } catch (error) {
      console.error('Błąd podczas pobierania symboli:', error);
      throw error;
    }
  };
  
    static postSymbol = async (request: Symbol) =>
      await axios.post<Symbol>("http://localhost:3000//{symbols}/addSymbol", request);
  
    static putSymbol = async (request: Symbol) =>
      await axios.put<Symbol>("http://localhost:3000/{symbols}/updateSymbol", request);
    
  }