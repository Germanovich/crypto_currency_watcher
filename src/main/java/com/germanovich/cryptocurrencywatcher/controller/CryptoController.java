package com.germanovich.cryptocurrencywatcher.controller;

import com.germanovich.cryptocurrencywatcher.dto.CryptoDto;

import com.germanovich.cryptocurrencywatcher.service.crypto.CryptoService;
import com.germanovich.cryptocurrencywatcher.controller.util.CryptoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("crypto")
@RequiredArgsConstructor
public class CryptoController {

    private final CryptoService cryptoService;

    @GetMapping("{id}")
    public double getCryptoPrice(@PathVariable final int id) {
        return cryptoService.getCryptoPrice(id);
    }

    @GetMapping
    public Collection<CryptoDto> getCryptoList() {
        return CryptoConverter.convertCryptoListToCryptoDtoList(cryptoService.getCryptoList());
    }
}
