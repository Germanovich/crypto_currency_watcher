package com.germanovich.cryptocurrencywatcher.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "crypto")
public class Crypto {

    @Id
    @Column(name = "id")
    protected Integer id;
    private String symbol;
    private double price;

    public Crypto(final int id, final String symbol) {
        this.id = id;
        this.symbol = symbol;
    }
}
