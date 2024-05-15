package com.ArkadiaPlocienniczak.CurrencyCheckerApp.price.controller;

import com.ArkadiaPlocienniczak.CurrencyCheckerApp.price.config.PriceDTO;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.price.model.Price;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.model.Symbol;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.price.service.PriceService;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.service.SymbolService;
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
import java.util.Optional;

@RestController
@RequestMapping("/price")
public class PriceController {

    private final PriceService priceService;
    private final SymbolService symbolService;

    public PriceController(PriceService priceService, SymbolService symbolService) {
        this.priceService = priceService;
        this.symbolService = symbolService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Price>> getAllPrice() {
        List<Price> prices = priceService.getAllPrice();
        return new ResponseEntity<>(prices, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/last/{symbol}")
    public ResponseEntity<PriceDTO> getLastPriceForGivenSymbol(@PathVariable String symbol) {
        Optional<PriceDTO> lastPrice = priceService.getLastPriceForSymbol(symbol);
        return lastPrice
                .map(priceDTO -> new ResponseEntity<>(priceDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/lastDay/{symbol}")
    public ResponseEntity<List<PriceDTO>> getLastForAllSymbolsForLastDay() {
        List<PriceDTO> lastPrices = priceService.getLastPriceForAllSymbolsForLastDay();
        if (lastPrices.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(lastPrices);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/lastAll")
    public ResponseEntity<List<PriceDTO>> getLastPriceForAllSymbols() {
        List<PriceDTO> lastPrices = priceService.getLastPriceForAllSymbols();
        if (lastPrices.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(lastPrices);
        }
    }

    @Scheduled(fixedRate = 600000)
    public void refreshLatestPrices() {
        List<Symbol> symbols = symbolService.getSymbols();
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
            }
        }
    }

    private PriceDTO fetchPriceFromApi(String apiUrl) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new URL(apiUrl), PriceDTO.class);
    }
}