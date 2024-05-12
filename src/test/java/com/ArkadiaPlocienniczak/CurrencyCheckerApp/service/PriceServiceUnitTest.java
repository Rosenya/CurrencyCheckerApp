package com.ArkadiaPlocienniczak.CurrencyCheckerApp.service;

import com.ArkadiaPlocienniczak.CurrencyCheckerApp.model.Price;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.repository.PriceRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PriceServiceUnitTest {

//    @Mock
//    private PriceRepository priceRepository;
//
//    @Autowired
//    private PriceService priceService;
//
//    @Test
//    public void testAddPrice() {
//        // Given
//        Price price = new Price();
//        price.setLastPrice(BigDecimal.valueOf(100.50));
//        price.setTimeStamp(LocalDateTime.now());
//
//        when(priceRepository.save(any(Price.class))).thenReturn(price);
//
//        // When
//        priceService.addPrice(price);
//
//        // Then
//        verify(priceRepository, Mockito.times(1)).save(any(Price.class));
//
//        assertThat(price.getLastPrice()).isEqualTo(BigDecimal.valueOf(100.50));
//        assertThat(price.getTimeStamp()).isNotNull();
//    }
}
