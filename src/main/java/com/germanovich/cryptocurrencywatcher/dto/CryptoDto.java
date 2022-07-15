package com.germanovich.cryptocurrencywatcher.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class CryptoDto {

    private int id;
    private String symbol;
}
