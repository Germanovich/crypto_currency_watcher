package com.germanovich.cryptocurrencywatcher.controller;

import com.germanovich.cryptocurrencywatcher.common.exception.BusinessException;
import com.germanovich.cryptocurrencywatcher.controller.util.MessageForUser;
import com.germanovich.cryptocurrencywatcher.dto.UserDto;

import com.germanovich.cryptocurrencywatcher.service.user.UserService;
import com.germanovich.cryptocurrencywatcher.controller.util.UserConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /** Body:
     * {
     *     "crypto": {
     *         "symbol": "BTC"
     *     },
     *     "username": "my_username"
     * }
     */
    @PostMapping("notify")
    public ResponseEntity<Void> addUser(@RequestBody final UserDto userDto) {
        if (userDto == null || userDto.getCrypto() == null) {
            throw new BusinessException(MessageForUser.MISSING_REQUIRED_DATA.get());
        }

        userService.addUser(UserConverter.convertUserDtoToUser(userDto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
