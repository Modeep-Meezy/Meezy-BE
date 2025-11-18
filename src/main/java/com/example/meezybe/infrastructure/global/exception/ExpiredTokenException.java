package com.example.meezybe.infrastructure.global.exception;

import com.example.meezybe.infrastructure.global.error.exception.GlobalErrorCode;
import com.example.meezybe.infrastructure.global.error.exception.MeezyException;

public class ExpiredTokenException extends MeezyException {

    public static final MeezyException EXCEPTION = new ExpiredTokenException();

    private ExpiredTokenException() {
        super(GlobalErrorCode.EXPIRED_TOKEN);
    }
}
