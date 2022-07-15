package com.germanovich.cryptocurrencywatcher.controller.util;

import com.germanovich.cryptocurrencywatcher.dto.UserDto;
import com.germanovich.cryptocurrencywatcher.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConverter {

    public UserDto convertUserToUserDto(final User user) {
        return UserDto.builder()
                .crypto(CryptoConverter.convertCryptoToCryptoDto(user.getCrypto()))
                .username(user.getUserName())
                .build();
    }

    public User convertUserDtoToUser(final UserDto userDto) {
        return User.builder()
                .crypto(CryptoConverter.convertCryptoDtoToCrypto(userDto.getCrypto()))
                .userName(userDto.getUsername())
                .build();
    }
}
