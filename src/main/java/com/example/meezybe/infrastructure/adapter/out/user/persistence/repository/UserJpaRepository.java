package com.example.meezybe.infrastructure.adapter.out.user.persistence.repository;

import com.example.meezybe.infrastructure.adapter.out.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByAccountId(String accountId);

    boolean existsByAccountId(String accountId);
}
