package com.ArkadiaPlocienniczak.CurrencyCheckerApp.controller;

import com.ArkadiaPlocienniczak.CurrencyCheckerApp.model.Symbol;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.service.SymbolService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;


import java.io.IOException;
import java.net.URL;
import java.util.List;

@Controller
public class SymbolController {

    private final SymbolService symbolService;

    public SymbolController(SymbolService symbolService) {
        this.symbolService = symbolService;
    }

    @GetMapping("/{symbols}")
    public ResponseEntity<List<Symbol>> getSymbol(@PathVariable(required = false, name = "symbolId") Long id){
        if(id == null){
            return new ResponseEntity<>(symbolService.getSymbol(), HttpStatus.OK);
        }
        Symbol symbol = symbolService.getSymbolById(id);
        return new ResponseEntity(symbol, HttpStatus.OK);
    }

    @PostMapping("/{symbols}/addSymbol")
    public ResponseEntity addSymbol(@RequestBody Symbol symbol){

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            URL apiUrl = new URL("https://api.binance.com/api/v3/ticker?symbol=" + symbol.getName());
            String symbolName = jsonNode.get("symbol").asText();
            symbol.setName(symbolName);
            symbolService.addSymbol(symbol);

        symbolService.addSymbol(symbol);
        return ResponseEntity.ok(symbol);
        } catch (IOException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PutMapping("/{symbols}/editSymbol")
    public ResponseEntity editCategory(@RequestBody Symbol symbol){
        symbolService.editSymbol(symbol);
        return ResponseEntity.ok(symbol);
    }

    @DeleteMapping("/{symbols}/deleteSymbol")
    public ResponseEntity deleteSymbol(@RequestParam("id") Long id){
        symbolService.deleteSymbolById(id);
        return ResponseEntity.ok(null);
    }


}
