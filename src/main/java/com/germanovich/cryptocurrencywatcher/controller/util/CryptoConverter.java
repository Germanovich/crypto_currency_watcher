package com.germanovich.cryptocurrencywatcher.controller.util;

import com.germanovich.cryptocurrencywatcher.dto.CryptoDto;
import com.germanovich.cryptocurrencywatcher.model.Crypto;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Collection;

@UtilityClass
public class CryptoConverter {
    public CryptoDto convertCryptoToCryptoDto(final Crypto crypto) {
        return CryptoDto.builder()
                .id(crypto.getId())
                .symbol(crypto.getSymbol())
                .build();
    }

    public Crypto convertCryptoDtoToCrypto(final CryptoDto cryptoDto) {
        return Crypto.builder()
                .id(cryptoDto.getId())
                .symbol(cryptoDto.getSymbol())
                .build();
    }

    public Collection<CryptoDto> convertCryptoListToCryptoDtoList(final Collection<Crypto> cryptoList) {
        Collection<CryptoDto> cryptoDtoList = new ArrayList<>();
        cryptoList.forEach(crypto -> cryptoDtoList.add(convertCryptoToCryptoDto(crypto)));
        return cryptoDtoList;
    }
}
