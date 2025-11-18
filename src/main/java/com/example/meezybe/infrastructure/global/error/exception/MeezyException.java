package com.example.meezybe.infrastructure.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MeezyException extends RuntimeException {

    private final ErrorProperty errorProperty;
}
