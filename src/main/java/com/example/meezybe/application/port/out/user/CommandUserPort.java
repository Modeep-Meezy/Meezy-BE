package com.example.meezybe.application.port.out.user;

import com.example.meezybe.domain.user.model.User;

public interface CommandUserPort {

    User save(User user);
}
