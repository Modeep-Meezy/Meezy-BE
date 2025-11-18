package com.example.meezybe.infrastructure.global.security.jwt;

import com.example.meezybe.infrastructure.global.exception.ExpiredTokenException;
import com.example.meezybe.infrastructure.global.exception.InvalidTokenException;
import com.example.meezybe.infrastructure.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
public class JwtParser {

    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;

    private SecretKey secretKey;

    @PostConstruct
    public void initSecretKey() {
        this.secretKey = Jwts.SIG.HS256.key().build();
        this.secretKey = io.jsonwebtoken.security.Keys.hmacShaKeyFor(jwtProperties.getSecretKey().getBytes(StandardCharsets.UTF_8));
    }

    public String resolve(HttpServletRequest request) {
        String bearerToken = request.getHeader(jwtProperties.getHeader());
        if (bearerToken != null && bearerToken.startsWith(jwtProperties.getPrefix())) {
            return bearerToken.replace(jwtProperties.getPrefix(), "").trim();
        }
        return null;
    }

    public Claims parseClaims(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getPayload();
        } catch (Exception e) {
            if (e instanceof ExpiredJwtException) {
                throw ExpiredTokenException.EXCEPTION;
            }
            throw InvalidTokenException.EXCEPTION;
        }
    }

    public String getSubject(String token) {
        return parseClaims(token).getSubject();
    }

    public Authentication getAuthentication(String token) {
        String subject = getSubject(token);
        UserDetails userDetails = authDetailsService.loadUserByUsername(subject);
        return new UsernamePasswordAuthenticationToken(
                userDetails,
                "",
                userDetails.getAuthorities()
        );
    }

    public boolean isRefreshToken(String token) {
        try {
            Claims claims = parseClaims(token);
            return "refresh".equals(claims.get("type"));
        } catch (Exception e) {
            return false;
        }
    }
}