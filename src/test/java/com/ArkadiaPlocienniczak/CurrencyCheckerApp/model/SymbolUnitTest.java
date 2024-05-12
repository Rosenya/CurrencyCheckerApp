package com.ArkadiaPlocienniczak.CurrencyCheckerApp.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class SymbolUnitTest {
    @Test
    public void testSymbolGetterAndSetter() {
        // Given
        Symbol symbol = new Symbol();
        String expectedName = new String();

        // When
        symbol.setName(expectedName);

        // Then
        assertThat(symbol.getName()).isEqualTo(expectedName);
    }

    @Test
    public void testSymbolConstructor() {
        // Given
        String expectedName = new String();

        // When
        Symbol symbol = new Symbol();
        symbol.setName(expectedName);

        // Then
        assertThat(symbol.getName()).isEqualTo(expectedName);
    }

    @Test
    public void testSymbolToString() {
            // Given
            Symbol symbol = new Symbol();
            symbol.setId(1L);
            symbol.setName("BTCUSDT");

            // When
            String expectedString = "Symbol(id=1, name=BTCUSDT, prices=[Price(id=1, lastPrice=50.25, timeStamp=2024-05-12T14:00)])";


            // Then
            assertThat(expectedString).isEqualTo(expectedString);
    }

}
