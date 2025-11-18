package com.example.meezybe.infrastructure.adapter.out.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "tbl_user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String accountId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String imageUrl;

    @Builder
    public UserEntity(Long id, String accountId, String username, String password, String email,  String imageUrl) {
        this.id = id;
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.imageUrl = imageUrl;
    }
}
