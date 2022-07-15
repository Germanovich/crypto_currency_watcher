package com.germanovich.cryptocurrencywatcher.repository;

import com.germanovich.cryptocurrencywatcher.model.Crypto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoRepository extends JpaRepository<Crypto, Integer> {

    Crypto findBySymbol(final String symbol);
}
