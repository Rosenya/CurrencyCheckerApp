package com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.controller;

import com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.config.SymbolDTO;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.model.Symbol;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.service.SymbolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SymbolController {

    private final SymbolService symbolService;

    public SymbolController(SymbolService symbolService) {
        this.symbolService = symbolService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/allSymbols")
    public ResponseEntity<List<SymbolDTO>> getSymbols() {
        List<SymbolDTO> symbols = symbolService.getSymbolsDTOs();
        return new ResponseEntity<>(symbols, HttpStatus.OK);
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/symbols/{symbol}")
    public ResponseEntity<SymbolDTO> getSymbolByName(@PathVariable String symbol) {
        Optional<SymbolDTO> symbolDTO = symbolService.getSymbolByName(symbol);
        if (symbolDTO.isPresent()) {
            return new ResponseEntity<>(symbolDTO.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/symbols")
    public ResponseEntity<Symbol> addSymbol(@RequestBody SymbolDTO symbolDTO){
            Symbol symbol = symbolService.addSymbol(symbolDTO);
            return ResponseEntity.ok(symbol);
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/symbols/{symbols}")
    public ResponseEntity<Void> updateSymbol(@PathVariable("symbols") Long id, @RequestBody Symbol symbol){
        Symbol existingSymbol = symbolService.getSymbolById(id);
        if (existingSymbol == null) {
            return ResponseEntity.notFound().build();
        }
        existingSymbol.setName(symbol.getName());
        symbolService.updateSymbol(existingSymbol);
        return ResponseEntity.noContent().build();
    }

}
