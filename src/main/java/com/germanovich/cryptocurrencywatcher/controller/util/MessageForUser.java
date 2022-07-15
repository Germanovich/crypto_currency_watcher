package com.germanovich.cryptocurrencywatcher.controller.util;

public enum MessageForUser {

    MISSING_REQUIRED_DATA("Missing required data"),
    CRYPTO_DO_NOT_EXIST("Cryptocurrencies do not exist"),
    REQUEST_METHOD_NOT_SUPPORTED("Request method not supported"),
    MEDIA_TYPE_NOT_SUPPORTED("Media type not supported"),
    MEDIA_TYPE_NOT_ACCEPTABLE("Media type not acceptable"),
    SERVER_ERROR("Server error"),
    BAD_REQUEST("Bad request"),
    NO_HANDLER_FOUND("No handler found"),
    SERVICE_UNAVAILABLE("Service unavailable"),
    NOT_ENOUGH_RIGHTS("Not enough rights");

    private final String message;

    MessageForUser(final String message) {
        this.message = message;
    }

    public String get() {
        return (this.message);
    }
}
