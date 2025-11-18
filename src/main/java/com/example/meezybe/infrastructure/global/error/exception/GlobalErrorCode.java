package com.example.meezybe.infrastructure.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GlobalErrorCode implements ErrorProperty{

    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "Token Expired"),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "Invalid Token"),

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");

    private final HttpStatus status;
    private final String message;
}