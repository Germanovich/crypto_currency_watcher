package com.germanovich.cryptocurrencywatcher.service.crypto;

import com.germanovich.cryptocurrencywatcher.common.exception.ApplicationException;
import com.germanovich.cryptocurrencywatcher.model.Crypto;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;

@Log4j2
@Component
public class CryptoInfoFlow {

    public Collection<Crypto> updatePrice(final Collection<Crypto> cryptoList) {
        Collection<Crypto> newCryptoList = new ArrayList<>();
        cryptoList.forEach(crypto -> newCryptoList.add(getCurrentCrypto(crypto.getId())));
        return newCryptoList;
    }

    private Crypto getCurrentCrypto(final int id) {
        String sUrl = "https://api.coinlore.net/api/ticker/?id=" + id;

        final InputStream content;
        try {
            URL url = new URL(sUrl);
            URLConnection request = url.openConnection();
            request.connect();
            content = (InputStream) request.getContent();
        } catch (final IOException e) {
            throw new ApplicationException(e);
        }

        JsonElement root = JsonParser.parseReader(new InputStreamReader(content));
        JsonObject object = (JsonObject) ((JsonArray)root).get(0);

        return Crypto.builder()
                .id(object.get("id").getAsInt())
                .symbol(object.get("symbol").getAsString())
                .price_usd(object.get("price_usd").getAsDouble())
                .build();
    }
}
