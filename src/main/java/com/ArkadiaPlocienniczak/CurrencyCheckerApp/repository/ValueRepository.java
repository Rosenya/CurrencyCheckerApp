package com.ArkadiaPlocienniczak.CurrencyCheckerApp.repository;

import com.ArkadiaPlocienniczak.CurrencyCheckerApp.model.Symbol;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.model.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ValueRepository extends JpaRepository<Value, Long> {
    List<Value> findByLast(LocalDateTime lastTimeStamp);
    List<Value> findByLastDay(LocalDateTime lastDay);
    List<Value> find
}
