package com.ArkadiaPlocienniczak.CurrencyCheckerApp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "prices")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_id")
    private Long id;
    @Column
    private BigDecimal price;
    @Column
    private LocalDateTime timeStamp;

    @ManyToOne
    @JoinColumn(name = "symbol_id")
    private Symbol symbol;


}
