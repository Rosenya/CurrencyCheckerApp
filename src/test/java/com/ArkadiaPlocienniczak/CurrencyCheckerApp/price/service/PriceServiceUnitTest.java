package com.ArkadiaPlocienniczak.CurrencyCheckerApp.price.service;

import com.ArkadiaPlocienniczak.CurrencyCheckerApp.price.config.PriceDTO;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.price.model.Price;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.price.repository.PriceRepository;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.price.utils.PriceMapper;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.model.Symbol;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.repository.SymbolRepository;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.service.SymbolService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PriceServiceUnitTest {

    @Mock
    private PriceRepository priceRepository;

    @Mock
    private PriceMapper priceMapper;

    @InjectMocks
    private PriceService priceService;
    @InjectMocks
    private SymbolService symbolService;
    private SymbolRepository symbolRepository;

    @Before(" ")
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllPrice() {
        // Given
        Price price1 = new Price();
        Price price2 = new Price();
        List<Price> priceList = List.of(price1, price2);

        when(priceRepository.findAll()).thenReturn(priceList);

        // When
        List<Price> result = priceService.getAllPrice();

        // Then
        assertEquals(2, result.size());
        assertEquals(priceList, result);
        verify(priceRepository, times(1)).findAll();
    }

    @Test
    public void testGetLastPriceForSymbol_symbolExists() {
        // Given
        Symbol symbol = new Symbol();
        Price price = new Price();

        when(symbolRepository.findByName(symbol.getName()));
        when(priceRepository.findFirstBySymbolOrderByTimeStampDesc(symbol)).thenReturn(Optional.of(price));

        // When
        Optional<PriceDTO> result = priceService.getLastPriceForSymbol(symbol.getName());

        // Then
        Optional<PriceDTO> expectedDTO = Optional.of(new PriceDTO(1L, new BigDecimal(150.00), "AAPL"));
        assertEquals(expectedDTO, result);

        verify(symbolRepository, times(1)).findByName(symbol.getName());
        verify(priceRepository, times(1)).findFirstBySymbolOrderByTimeStampDesc(symbol);
    }

    @Test
    public void testGetLastPriceForSymbol_symbolNotExists() {
        // Given
        String symbolName = "MSFT";

        when(symbolRepository.findByName(symbolName)).thenReturn(Optional.empty());

        // When
        Optional<PriceDTO> result = priceService.getLastPriceForSymbol(symbolName);

        // Then
        assertEquals(Optional.empty(), result);
        verify(symbolRepository, times(1)).findByName(symbolName);
        verify(priceRepository, never()).findFirstBySymbolOrderByTimeStampDesc(any());
    }
}
