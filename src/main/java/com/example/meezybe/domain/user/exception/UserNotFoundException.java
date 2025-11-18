package com.example.meezybe.domain.user.exception;

import com.example.meezybe.domain.user.exception.error.UserErrorCode;
import com.example.meezybe.infrastructure.global.error.exception.MeezyException;

public class UserNotFoundException extends MeezyException {

    public static final MeezyException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(UserErrorCode.USER_NOT_FOUND);
    }
}
