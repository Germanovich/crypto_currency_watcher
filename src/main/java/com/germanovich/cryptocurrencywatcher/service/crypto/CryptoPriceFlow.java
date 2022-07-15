package com.germanovich.cryptocurrencywatcher.service.crypto;

import com.germanovich.cryptocurrencywatcher.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Log4j2
@Component
public class CryptoPriceFlow {

    public void checkPrice(final Collection<User> users) {
        users.forEach(user -> {
            double percent = getDifference(user.getCrypto().getPrice(), user.getStartCryptoPrice());
            if (Math.abs(percent) > 1) {
                log.warn('\"' + user.getCrypto().getSymbol() + '\"'
                        + ":\"" + user.getUserName() + '\"'
                        + ": " + percent + " %");
            }
        });
    }

    private double getDifference(final double firstPrice, final double secondPrice) {
        return 100 - secondPrice * 100 / firstPrice;
    }
}
