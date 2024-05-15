package com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.repository;

import com.ArkadiaPlocienniczak.CurrencyCheckerApp.symbol.model.Symbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SymbolRepository extends JpaRepository<Symbol, Long> {
    Optional<Symbol> findByName(String name);
}
