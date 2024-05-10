package com.ArkadiaPlocienniczak.CurrencyCheckerApp.repository;

import com.ArkadiaPlocienniczak.CurrencyCheckerApp.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
}
