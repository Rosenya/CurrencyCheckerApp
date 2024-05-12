package com.ArkadiaPlocienniczak.CurrencyCheckerApp.controller;

import com.ArkadiaPlocienniczak.CurrencyCheckerApp.config.PriceDTO;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.model.Price;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.model.Symbol;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.service.PriceService;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.service.SymbolService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/last")
public class PriceController {

    private final PriceService priceService;
    private final SymbolService symbolService;

    public PriceController(PriceService priceService, SymbolService symbolService) {
        this.priceService = priceService;
        this.symbolService = symbolService;
    }

    @GetMapping
    public ResponseEntity<List<Price>> getAllPrice() {
        List<Price> prices = priceService.getAllPrice();
        return new ResponseEntity<>(prices, HttpStatus.OK);
    }

    @GetMapping("/{lastPriceId}")
    public ResponseEntity<Price> getPriceById(@PathVariable Long lastPriceId) {
        Price price = priceService.getPriceById(lastPriceId);
        if (price != null) {
            return new ResponseEntity<>(price, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Scheduled(fixedRate = 600000)
    public void refreshLatestPrices() {
        List<Symbol> symbols = symbolService.getSymbol();
        for (Symbol symbol : symbols) {
            try {
                String apiUrl = "https://api.binance.com/api/v3/ticker?symbol=" + symbol.getName().toUpperCase();
                PriceDTO response = fetchPriceFromApi(apiUrl);

                if (response != null && response.getLastPrice() != null) {
                    BigDecimal priceValue = response.getLastPrice();

                    Price latestPrice = new Price();
                    latestPrice.setLastPrice(priceValue);
                    latestPrice.setTimeStamp(LocalDateTime.now());
                    latestPrice.setSymbol(symbol);

                    priceService.addPrice(latestPrice);
                }
            } catch (Exception e) {
                System.err.println("Failed to fetch price data from Binance API for symbol: " + symbol.getName());
                e.printStackTrace();
            }
        }
    }

    private PriceDTO fetchPriceFromApi(String apiUrl) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new URL(apiUrl), PriceDTO.class);
    }
}