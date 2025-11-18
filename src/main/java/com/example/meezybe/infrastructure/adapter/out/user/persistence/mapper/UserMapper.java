package com.example.meezybe.infrastructure.adapter.out.user.persistence.mapper;

import com.example.meezybe.domain.user.model.User;
import com.example.meezybe.infrastructure.adapter.out.user.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMapper {

    public UserEntity toEntity(User domain) {
        return UserEntity.builder()
                .id(domain.getId())
                .accountId(domain.getAccountId())
                .password(domain.getPassword())
                .username(domain.getUsername())
                .email(domain.getEmail())
                .imageUrl(domain.getImageUrl())
                .build();
    }

    public User toDomain(UserEntity entity) {
        return User.builder()
                .id(entity.getId())
                .accountId(entity.getAccountId())
                .password(entity.getPassword())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .imageUrl(entity.getImageUrl())
                .build();
    }
}
