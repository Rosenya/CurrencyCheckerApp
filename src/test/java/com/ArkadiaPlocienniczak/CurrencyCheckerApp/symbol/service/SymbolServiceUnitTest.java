package com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.service;

import com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.config.SymbolDTO;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.model.Symbol;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.repository.SymbolRepository;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.utils.SymbolMapper;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class SymbolServiceUnitTest {
//    @Mock
//    private SymbolRepository symbolRepository;
//
//    @Mock
//    private SymbolMapper symbolMapper;
//
//    @InjectMocks
//    private SymbolService symbolService;
//
//    @Before("")
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testGetSymbolsDTOs() {
//        // Given
//        Symbol symbol1 = new Symbol();
//        Symbol symbol2 = new Symbol();
//        List<Symbol> symbolList = Arrays.asList(symbol1, symbol2);
//        List<SymbolDTO> expectedDTOList = Arrays.asList(new SymbolDTO("BTC"), new SymbolDTO("ETH"));
//
//        when(symbolRepository.findAll()).thenReturn(symbolList);
//        when(symbolMapper.symbolToDTO(symbol1)).thenReturn(new SymbolDTO("BTC"));
//        when(symbolMapper.symbolToDTO(symbol2)).thenReturn(new SymbolDTO("ETH"));
//
//        // When
//        List<SymbolDTO> resultDTOList = symbolService.getSymbolsDTOs();
//
//        // Then
//        assertEquals(expectedDTOList, resultDTOList);
//        verify(symbolRepository, times(1)).findAll();
//        verify(symbolMapper, times(1)).symbolToDTO(symbol1);
//        verify(symbolMapper, times(1)).symbolToDTO(symbol2);
//    }
}

