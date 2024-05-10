package com.ArkadiaPlocienniczak.CurrencyCheckerApp.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PriceDTO {

    private Long id;
    @JsonProperty
    private BigDecimal price;
    private LocalDateTime timestamp;
}
