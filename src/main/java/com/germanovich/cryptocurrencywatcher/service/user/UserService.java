package com.germanovich.cryptocurrencywatcher.service.user;

import com.germanovich.cryptocurrencywatcher.common.exception.BusinessException;
import com.germanovich.cryptocurrencywatcher.controller.util.MessageForUser;
import com.germanovich.cryptocurrencywatcher.model.Crypto;
import com.germanovich.cryptocurrencywatcher.model.User;
import com.germanovich.cryptocurrencywatcher.repository.CryptoRepository;
import com.germanovich.cryptocurrencywatcher.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CryptoRepository cryptoRepository;

    @Transactional
    public void addUser(final User user) {
        verifyUser(user);

        Crypto crypto = cryptoRepository.findBySymbol(user.getCrypto().getSymbol());
        userRepository.save(new User(user.getUserName(), crypto));
    }

    private void verifyUser(final User user) {
        if (user == null
                || user.getUserName() == null
                || user.getCrypto() == null
                || user.getCrypto().getSymbol() == null) {
            throw new BusinessException(MessageForUser.MISSING_REQUIRED_DATA.get());
        }

        if (cryptoRepository.findBySymbol(user.getCrypto().getSymbol()) == null) {
            throw new BusinessException(MessageForUser.MISSING_REQUIRED_DATA.get());
        }
    }
}
