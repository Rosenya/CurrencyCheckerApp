package com.ArkadiaPlocienniczak.CurrencyCheckerApp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "values")
public class Value {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "values_id")
    private Long id;
    @Column
    private BigDecimal value;
    @Column
    private LocalDateTime timeStamp;

    @ManyToOne
    @JoinColumn(name = "symbols_id")
    private Symbol symbol;


}
