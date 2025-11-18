package com.example.meezybe.infrastructure.global.error;

import com.example.meezybe.infrastructure.global.error.exception.ErrorProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private final Integer status;
    private final String message;

    public static ErrorResponse of(ErrorProperty errorProperty) {
        return new ErrorResponse(errorProperty.getStatus().value(), errorProperty.getMessage());
    }
}
