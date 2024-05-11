package com.ArkadiaPlocienniczak.CurrencyCheckerApp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "symbols")
public class Symbol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "symbol_id")
    private Long id;
    @Column
    private String name;

    @OneToMany(mappedBy = "symbol", fetch = FetchType.EAGER)
    private List<Price> prices = new ArrayList<>();
}
