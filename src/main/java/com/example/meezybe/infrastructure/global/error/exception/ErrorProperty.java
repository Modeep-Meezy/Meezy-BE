package com.example.meezybe.infrastructure.global.error.exception;

import org.springframework.http.HttpStatus;

public interface ErrorProperty {

    HttpStatus getStatus();

    String getMessage();
}
