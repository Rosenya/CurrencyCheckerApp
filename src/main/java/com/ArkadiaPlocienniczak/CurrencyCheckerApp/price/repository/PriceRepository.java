package com.ArkadiaPlocienniczak.CurrencyCheckerApp.price.repository;

import com.ArkadiaPlocienniczak.CurrencyCheckerApp.price.model.Price;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.model.Symbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    Optional<Price> findFirstBySymbolOrderByTimeStampDesc(Symbol symbol);
    List<Price> findFirstListBySymbolOrderByTimeStampDesc(Symbol symbol);
    List<Price> findPricesBySymbolAndTimeStampAfter(Symbol symbol, LocalDateTime lastTwentyFourHours);
}
