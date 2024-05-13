package com.ArkadiaPlocienniczak.CurrencyCheckerApp.controller;

import com.ArkadiaPlocienniczak.CurrencyCheckerApp.config.SymbolDTO;
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

@RestController
@RequestMapping("/symbols")
public class SymbolController {

    private final SymbolService symbolService;

    public SymbolController(SymbolService symbolService) {
        this.symbolService = symbolService;
    }

//    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{symbols}")
    public ResponseEntity<List<Symbol>> getSymbols() {
        List<Symbol> symbols = symbolService.getSymbol();
        return new ResponseEntity<>(symbols, HttpStatus.OK);
    }

    @GetMapping("/{symbolId}")
    public ResponseEntity<Symbol> getSymbolById(@PathVariable Long symbolId) {
        Symbol symbol = symbolService.getSymbolById(symbolId);
        if (symbol != null) {
            return new ResponseEntity<>(symbol, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{symbols}/addSymbol")
    public ResponseEntity addSymbol(@RequestBody Symbol symbol){
            symbolService.addSymbol(symbol);
            return ResponseEntity.ok(symbol);
    }


    @PutMapping("/{symbols}/updateSymbol")
    public ResponseEntity updateSymbol(@PathVariable("symbols") Long id, @RequestBody Symbol symbol){
        Symbol existingSymbol = symbolService.getSymbolById(id);
        if (existingSymbol == null) {
            return ResponseEntity.notFound().build();
        }
        existingSymbol.setName(symbol.getName());
        symbolService.updateSymbol(existingSymbol);
        return ResponseEntity.ok(existingSymbol);
    }

}
