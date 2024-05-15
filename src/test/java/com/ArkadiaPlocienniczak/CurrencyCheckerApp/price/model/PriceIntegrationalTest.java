//package com.ArkadiaPlocienniczak.CurrencyCheckerApp.price.model;
//
//import com.ArkadiaPlocienniczak.CurrencyCheckerApp.price.repository.PriceRepository;
//import com.ArkadiaPlocienniczak.CurrencyCheckerApp.price.service.PriceService;
//import com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.model.Symbol;
//import com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.repository.SymbolRepository;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//public class PriceIntegrationalTest {
//
//    @Mock
//    private SymbolRepository symbolRepository;
//
//    @Mock
//    private PriceRepository priceRepository;
//
//    @InjectMocks
//    private PriceService priceService;
//
//    @Test
//    public void testPriceWithSymbol() {
//
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
//
//        when(priceRepository.findById(1L)).thenReturn(Optional.of(price));
//        when(symbolRepository.findById(1L)).thenReturn(Optional.of(symbol));
//
//
//        Price retrievedPrice = priceService.getPriceById(1L);
//
//
//        assertThat(retrievedPrice).isNotNull();
//        assertThat(retrievedPrice.getSymbol()).isNotNull();
//        assertThat(retrievedPrice.getSymbol().getName()).isEqualTo("BTCUSDT");
//    }
//}
