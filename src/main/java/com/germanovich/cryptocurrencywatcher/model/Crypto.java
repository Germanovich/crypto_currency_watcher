package com.germanovich.cryptocurrencywatcher.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "crypto")
public class Crypto extends AEntity {

    private String symbol;
    private double price_usd;

    public Crypto(final int id, final String symbol) {
        this.id = id;
        this.symbol = symbol;
    }
}
