package com.ArkadiaPlocienniczak.CurrencyCheckerApp.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceDTO {

    private Long id;
    @JsonProperty("lastPrice")
    private BigDecimal lastPrice;
    private String symbol;
}
