package com.germanovich.cryptocurrencywatcher.service.crypto;

import com.germanovich.cryptocurrencywatcher.common.exception.BusinessException;
import com.germanovich.cryptocurrencywatcher.controller.util.MessageForUser;
import com.germanovich.cryptocurrencywatcher.model.Crypto;
import com.germanovich.cryptocurrencywatcher.repository.CryptoRepository;
import com.germanovich.cryptocurrencywatcher.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class CryptoService {

    private final CryptoInfoFlow cryptoInfoFlow;
    private final CryptoPriceFlow cryptoPriceFlow;
    private final CryptoRepository cryptoRepository;
    private final UserRepository userRepository;

    public double getCryptoPrice(final int id) {
        Crypto crypto = cryptoRepository.findById(id)
                .orElseThrow(() -> new BusinessException(MessageForUser.CRYPTO_DO_NOT_EXIST.get()));
        return crypto.getPrice_usd();
    }

    public Collection<Crypto> getCryptoList() {
        return cryptoRepository.findAll();
    }

    @Scheduled(fixedRate = 60000)
    public void cryptoObserver() {
        if (cryptoRepository.findAll().size() == 0) {
            loadCrypto();
        }

        updateCrypto(cryptoRepository.findAll());
        cryptoPriceFlow.checkPrice(userRepository.findAll());
    }

    @Transactional
    private void updateCrypto(final Collection<Crypto> cryptoList) {
        cryptoRepository.saveAll(cryptoInfoFlow.updatePrice(cryptoList));
    }

    private void loadCrypto() {
        cryptoRepository.saveAll(Arrays.asList(
                new Crypto(90, "BTC"),
                new Crypto(80, "ETH"),
                new Crypto(48543, "SOL"))
        );
    }
}
