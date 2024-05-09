package com.ArkadiaPlocienniczak.CurrencyCheckerApp.repository;

import com.ArkadiaPlocienniczak.CurrencyCheckerApp.model.Symbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymbolRepository extends JpaRepository<Symbol, Long> {
}
