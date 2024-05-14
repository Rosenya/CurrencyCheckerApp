package com.ArkadiaPlocienniczak.CurrencyCheckerApp.repository;

import com.ArkadiaPlocienniczak.CurrencyCheckerApp.model.Symbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SymbolRepository extends JpaRepository<Symbol, Long> {
    Optional<Symbol> findByName(String name);
}
