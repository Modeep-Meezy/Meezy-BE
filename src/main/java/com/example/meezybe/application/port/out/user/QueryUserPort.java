package com.example.meezybe.application.port.out.user;

import com.example.meezybe.domain.user.model.User;

public interface QueryUserPort {

    boolean existsByAccountId(String accountId);

    User getByAccountIdOrThrow(String accountId);
}
