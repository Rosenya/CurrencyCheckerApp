package com.ArkadiaPlocienniczak.CurrencyCheckerApp.model;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PriceIntegrationalTest {

//    @Mock
//    private SymbolRepository symbolRepository;
//
//    @Mock
//    private PriceRepository priceRepository;
//
//    @InjectMocks
//    private PriceService priceService; // Zakładając, że istnieje serwis obsługujący operacje na Price
//
//    @Test
//    public void testPriceWithSymbol() {
//        // Przygotowanie danych
//        Symbol symbol = new Symbol();
//        symbol.setId(1L);
//        symbol.setName("BTCUSDT");
//
//        Price price = new Price();
//        price.setId(1L);
//        price.setLastPrice(new BigDecimal("50000.00"));
//        price.setTimeStamp(LocalDateTime.now());
//        price.setSymbol(symbol);
//
//        // Symulacja repozytorium
//        when(priceRepository.findById(1L)).thenReturn(Optional.of(price));
//        when(symbolRepository.findById(1L)).thenReturn(Optional.of(symbol));
//
//        // Pobranie ceny z symbolem
//        Price retrievedPrice = priceService.getPriceById(1L);
//
//        // Sprawdzenie, czy cena ma przypisany poprawny symbol
//        assertThat(retrievedPrice).isNotNull();
//        assertThat(retrievedPrice.getSymbol()).isNotNull();
//        assertThat(retrievedPrice.getSymbol().getName()).isEqualTo("BTCUSDT");
//    }
}
