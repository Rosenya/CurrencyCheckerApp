package com.ArkadiaPlocienniczak.CurrencyCheckerApp.service;

import com.ArkadiaPlocienniczak.CurrencyCheckerApp.config.PriceDTO;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.model.Price;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.model.Symbol;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.repository.PriceRepository;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.repository.SymbolRepository;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.utils.PriceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PriceService {

    private final PriceRepository priceRepository;
    private final SymbolRepository symbolRepository;
    private final PriceMapper priceMapper;

    public PriceService(PriceRepository priceRepository, SymbolRepository symbolRepository, PriceMapper priceMapper) {
        this.priceRepository = priceRepository;
        this.symbolRepository = symbolRepository;
        this.priceMapper = priceMapper;
    }

    public List<Price> getAllPrice(){
        return priceRepository.findAll();
    }

    public Price getPriceById(Long id){
        return priceRepository.findById(id).orElse(null);
    }

    public Optional<PriceDTO> getLastPriceForSymbol(String symbol) {
        Optional<Symbol> symbolObject = symbolRepository.findByName(symbol);

        if (symbolObject.isPresent()) {
            return priceRepository.findFirstBySymbolOrderByTimeStampDesc(symbolObject.get())
                    .map(priceMapper::priceToDTO);
        } else {
            return Optional.empty();
        }
    }

    public List<PriceDTO> getLastPriceForAllSymbolsForLastDay() {
        LocalDateTime lastPriceForTwentyFourHours = LocalDateTime.now().minusHours(24);
        List<Symbol> symbols = symbolRepository.findAll();
        List<PriceDTO> priceDTOs = new ArrayList<>();
        for (Symbol symbol : symbols) {
            List<Price> lastPricesForSymbol = priceRepository.findPricesBySymbolAndTimeStampAfter(symbol, lastPriceForTwentyFourHours);
            for (Price price : lastPricesForSymbol) {
                priceDTOs.add(priceMapper.priceToDTO(price));
            }
        }

        return priceDTOs;
    }

    public List<PriceDTO> getLastPriceForAllSymbols() {
            List<Symbol> symbols = symbolRepository.findAll();
            List<PriceDTO> priceDTOs = new ArrayList<>();
        for (Symbol symbol : symbols) {
            List<Price> lastPrices = priceRepository.findFirstListBySymbolOrderByTimeStampDesc(symbol);

            if (!lastPrices.isEmpty()) {
                Price lastPrice = lastPrices.get(0);
                PriceDTO priceDTO = priceMapper.priceToDTO(lastPrice);
                priceDTOs.add(priceDTO);
        }
    }
    return priceDTOs;
}

    @Transactional
    public void addPrice(Price price){
        priceRepository.save(price);
        log.info("Added latest price: " + price);
    }

}

