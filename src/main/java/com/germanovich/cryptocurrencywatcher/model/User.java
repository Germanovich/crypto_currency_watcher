package com.germanovich.cryptocurrencywatcher.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "app_user")
public class User extends AEntity {

    @Column(name = "user_name")
    private String userName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "crypto_id", referencedColumnName = "id")
    private Crypto crypto;
    private double startCryptoPrice;

    public User(final String username, final Crypto crypto) {
        this.userName = username;
        this.crypto = crypto;
        this.startCryptoPrice = crypto.getPrice_usd();
    }
}
