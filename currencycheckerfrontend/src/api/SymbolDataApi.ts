import axios from "axios";

export class SymbolDataApi {
    static getSymbols = async () =>
      await axios.get<Symbol[]>("http://localhost:3000/{symbols}");
  
    static postSymbol = async (request: Symbol) =>
      await axios.post<Symbol>("http://localhost:3000//{symbols}/addSymbol", request);
  
    static putSymbol = async (request: Symbol) =>
      await axios.put<Symbol>("http://localhost:3000/{symbols}/updateSymbol", request);
    
  }