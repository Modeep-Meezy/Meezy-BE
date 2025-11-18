package com.example.meezybe.infrastructure.global.security.auth;

import com.example.meezybe.infrastructure.adapter.out.user.persistence.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final UserJpaRepository userJpaRepository;

    @Override
    public UserDetails loadUserByUsername(String accountId) throws UsernameNotFoundException {
        return userJpaRepository.findByAccountId(accountId)
                .map(AuthDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(accountId));
    }
}
