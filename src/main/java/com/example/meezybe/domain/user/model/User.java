package com.example.meezybe.domain.user.model;

import com.example.meezybe.domain.annotation.Aggregate;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
@Aggregate
public class User {

    private final Long id;

    private final String accountId;

    private final String username;

    private final String password;

    private final String email;

    private final String imageUrl;

    public User updatePassword(String password) {
        return this.toBuilder()
                .password(password)
                .build();
    }
}
