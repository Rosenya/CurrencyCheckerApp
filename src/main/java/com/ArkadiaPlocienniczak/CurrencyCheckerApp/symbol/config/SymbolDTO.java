package com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SymbolDTO {

    @JsonProperty("symbol")
    private String name;

}