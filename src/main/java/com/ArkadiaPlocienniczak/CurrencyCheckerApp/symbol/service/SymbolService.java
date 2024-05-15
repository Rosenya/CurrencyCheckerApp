package com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.service;

import com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.config.SymbolDTO;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.model.Symbol;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.repository.SymbolRepository;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.utils.SymbolMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SymbolService {

    private SymbolRepository symbolRepository;
    private SymbolMapper symbolMapper;

    public SymbolService(SymbolRepository symbolRepository, SymbolMapper symbolMapper) {
        this.symbolRepository = symbolRepository;
        this.symbolMapper = symbolMapper;
    }

    public List<SymbolDTO> getSymbolsDTOs(){
        List<Symbol> symbolList = symbolRepository.findAll();
        List<SymbolDTO> symbolDTOList = symbolList.stream().map(symbolMapper::symbolToDTO).collect(Collectors.toList());
        return symbolDTOList;
    }

    public List<Symbol> getSymbols(){
        return symbolRepository.findAll();
    }

    public Symbol getSymbolById(Long id){
        return symbolRepository.findById(id).orElse(null);
    }

    public Optional<SymbolDTO> getSymbolByName(String name){
        return symbolRepository.findByName(name).map(symbolMapper::symbolToDTO);
    }

    public Symbol addSymbol(SymbolDTO symbolDTO){
        Symbol symbol = symbolMapper.fromDTO(symbolDTO);
        Symbol savedSymbol = symbolRepository.save(symbol);
        log.info("Added symbol: " + symbolDTO.getName());
        return savedSymbol;
    }

    public void updateSymbol(Symbol symbol){
        symbolRepository.save(symbol);
    }

}
