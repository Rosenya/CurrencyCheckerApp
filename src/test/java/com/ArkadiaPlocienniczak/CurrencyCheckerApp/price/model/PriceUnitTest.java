package com.ArkadiaPlocienniczak.CurrencyCheckerApp.price.model;

import com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.model.Symbol;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PriceUnitTest {

    @Test
    public void testPriceGetterAndSetter() {
        // Given
        Price price = new Price();
        BigDecimal expectedPrice = new BigDecimal("100.50");
        LocalDateTime expectedTimestamp = LocalDateTime.of(2024, 5, 12, 12, 30);
        Symbol expectedSymbol = new Symbol();

        // When
        price.setLastPrice(expectedPrice);
        price.setTimeStamp(expectedTimestamp);
        price.setSymbol(expectedSymbol);

        // Then
        assertThat(price.getLastPrice()).isEqualTo(expectedPrice);
        assertThat(price.getTimeStamp()).isEqualTo(expectedTimestamp);
        assertThat(price.getSymbol()).isEqualTo(expectedSymbol);
    }

    @Test
    public void testPriceConstructor() {
        // Given
        BigDecimal expectedPrice = new BigDecimal("75.20");
        LocalDateTime expectedTimestamp = LocalDateTime.of(2024, 5, 12, 13, 45);
        Symbol expectedSymbol = new Symbol();

        // When
        Price price = new Price();
        price.setLastPrice(expectedPrice);
        price.setTimeStamp(expectedTimestamp);
        price.setSymbol(expectedSymbol);

        // Then
        assertThat(price.getLastPrice()).isEqualTo(expectedPrice);
        assertThat(price.getTimeStamp()).isEqualTo(expectedTimestamp);
        assertThat(price.getSymbol()).isEqualTo(expectedSymbol);
    }

    @Test
    public void testPriceToString() {
        // Given
        Price price = new Price();
        price.setId(1L);
        price.setLastPrice(new BigDecimal("50.25"));
        price.setTimeStamp(LocalDateTime.of(2024, 5, 12, 14, 0));


        // When
        String expectedString = "Price{id=1, lastPrice=50.25, timeStamp=2024-05-12T14:00}";

        // Then
        assertThat(price.toString()).isEqualTo(expectedString);
    }
}
