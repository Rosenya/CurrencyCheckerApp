package com.ArkadiaPlocienniczak.CurrencyCheckerApp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@Entity
@Data
@Table(name = "symbols")
public class Symbol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "symbols_id")
    private Long id;
    @Column
    private String name;

    @OneToMany(mappedBy = "symbols", cascade = CascadeType.ALL)
    private List<Value> values = new ArrayList<>();
}
