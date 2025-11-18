package com.example.meezybe.infrastructure.adapter.out.user;

import com.example.meezybe.application.port.out.user.UserPort;
import com.example.meezybe.domain.user.exception.UserNotFoundException;
import com.example.meezybe.domain.user.model.User;
import com.example.meezybe.infrastructure.adapter.out.user.persistence.mapper.UserMapper;
import com.example.meezybe.infrastructure.adapter.out.user.persistence.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPort {

    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    @Override
    public User getByAccountIdOrThrow(String accountId) {
        return userJpaRepository.findByAccountId(accountId)
                .map(userMapper::toDomain)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);
    }

    @Override
    public boolean existsByAccountId(String accountId) {
        return userJpaRepository.existsByAccountId(accountId);
    }

    @Override
    public User save(User user) {
        return userMapper.toDomain(
                userJpaRepository.save(userMapper.toEntity(user))
        );
    }
}
