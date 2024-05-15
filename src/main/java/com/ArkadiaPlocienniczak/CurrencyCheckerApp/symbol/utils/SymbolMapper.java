package com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.utils;

import com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.config.SymbolDTO;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.model.Symbol;
import org.springframework.stereotype.Component;

@Component
public class SymbolMapper {

    public SymbolDTO symbolToDTO(Symbol symbol){
        SymbolDTO symbolDTO = new SymbolDTO();
        symbolDTO.setName(symbol.getName());
        return symbolDTO;
    }

    public Symbol fromDTO(SymbolDTO symbolDTO) {
       Symbol symbol = new Symbol();
       symbol.setName(symbolDTO.getName());
       return symbol;
    }
}
