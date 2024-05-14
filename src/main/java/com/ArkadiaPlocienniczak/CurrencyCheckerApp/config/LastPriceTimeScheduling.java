//package com.ArkadiaPlocienniczak.CurrencyCheckerApp.config;
//
//import com.ArkadiaPlocienniczak.CurrencyCheckerApp.model.Price;
//import com.ArkadiaPlocienniczak.CurrencyCheckerApp.model.Symbol;
//import com.ArkadiaPlocienniczak.CurrencyCheckerApp.service.PriceService;
//import com.ArkadiaPlocienniczak.CurrencyCheckerApp.service.SymbolService;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.net.URL;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Component
//public class LastPriceTimeScheduling {
//
//    private final SymbolService symbolService;
//    private final PriceService priceService;
//    private final RestTemplate restTemplate;
//
//    @Value("${binance.api.url}")
//    private String binanceApiBaseUrl;
//
//    public LastPriceTimeScheduling(SymbolService symbolService, PriceService priceService, RestTemplate restTemplate) {
//        this.symbolService = symbolService;
//        this.priceService = priceService;
//        this.restTemplate = restTemplate;
//    }
//
//    @Scheduled(cron = "${job.schedule}")
//    public void refreshLatestPrices() {
//        List<Symbol> symbols = symbolService.getSymbol();
//        for (Symbol symbol : symbols) {
//            try {
//                String apiUrl = binanceApiBaseUrl + symbol.getName().toUpperCase();
//                PriceDTO response = fetchPriceFromApi(apiUrl);
//
//                if (response != null && response.getLastPrice() != null) {
//                    BigDecimal priceValue = response.getLastPrice();
//
//                    Price latestPrice = new Price();
//                    latestPrice.setLastPrice(priceValue);
//                    latestPrice.setTimeStamp(LocalDateTime.now());
//                    latestPrice.setSymbol(symbol);
//
//                    priceService.addPrice(latestPrice);
//                }
//            } catch (Exception e) {
//                System.err.println("Failed to fetch price data from Binance API for symbol: " + symbol.getName());
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private PriceDTO fetchPriceFromApi(String apiUrl) {
//        try {
//            return restTemplate.getForObject(apiUrl, PriceDTO.class);
//        } catch (Exception e) {
//            System.err.println("Failed to fetch data from API: " + apiUrl);
//            e.printStackTrace();
//            return null;
//        }
//    }
//}