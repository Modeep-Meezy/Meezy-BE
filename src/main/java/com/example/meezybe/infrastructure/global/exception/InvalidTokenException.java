package com.example.meezybe.infrastructure.global.exception;

import com.example.meezybe.infrastructure.global.error.exception.GlobalErrorCode;
import com.example.meezybe.infrastructure.global.error.exception.MeezyException;

public class InvalidTokenException extends MeezyException {

    public static final MeezyException EXCEPTION  = new InvalidTokenException();

    private InvalidTokenException(){
        super(GlobalErrorCode.INVALID_TOKEN);
    }
}
