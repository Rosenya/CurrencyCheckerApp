package com.ArkadiaPlocienniczak.CurrencyCheckerApp.utils;

import com.ArkadiaPlocienniczak.CurrencyCheckerApp.config.PriceDTO;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.config.SymbolDTO;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.model.Symbol;
import org.springframework.stereotype.Component;

@Component
public class SymbolMapper {

    public SymbolDTO symbolToDTO(Symbol symbol){
        SymbolDTO symbolDTO = new SymbolDTO();
        symbolDTO.setName(symbol.getName());
        return symbolDTO;
    }
}
