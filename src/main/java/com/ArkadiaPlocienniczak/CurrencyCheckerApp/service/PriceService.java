package com.ArkadiaPlocienniczak.CurrencyCheckerApp.service;

import com.ArkadiaPlocienniczak.CurrencyCheckerApp.model.Price;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.model.Symbol;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.repository.PriceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class PriceService {

    private PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public List<Price> getAllPrice(){
        return priceRepository.findAll();
    }

    public Price getPriceById(Long id){
        return priceRepository.findById(id).orElse(null);
    }

    public void addPrice(Price price){
        log.info("Before saving price: " + price);
        priceRepository.save(price);
        log.info("Added latest price: " + price);
    }

    public void deletePast24hById(Long id){
        priceRepository.deleteById(id);
        log.info("Deleted value: " + id);
    }
}

