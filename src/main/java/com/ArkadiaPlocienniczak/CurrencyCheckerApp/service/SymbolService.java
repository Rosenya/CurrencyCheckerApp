package com.ArkadiaPlocienniczak.CurrencyCheckerApp.service;

import com.ArkadiaPlocienniczak.CurrencyCheckerApp.model.Symbol;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.repository.SymbolRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SymbolService {

    private SymbolRepository symbolRepository;

    public SymbolService(SymbolRepository symbolRepository) {
        this.symbolRepository = symbolRepository;
    }

    public List<Symbol> getSymbol(){
        return symbolRepository.findAll();
    }

    public Symbol getSymbolById(Long id){
        return symbolRepository.findById(id).orElse(null);
    }

    public Symbol getSymbolByName(String name){
        return symbolRepository.findByName(name);
    }

    public void saveSymbol(Symbol symbol) {
        symbolRepository.save(symbol);
    }

    public void addSymbol(Symbol symbol){
        symbolRepository.save(symbol);
        log.info("Added symbol: " + symbol.getName());
    }

    public void editSymbol(Symbol symbol){
        symbolRepository.save(symbol);
    }

    public void deleteSymbolById(Long id){
        symbolRepository.deleteById(id);
        log.info("Deleted symbol: " + id);
    }
}
