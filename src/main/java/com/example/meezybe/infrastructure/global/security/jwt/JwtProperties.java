package com.example.meezybe.infrastructure.global.security.jwt;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    private String secretKey;
    private String header;
    private String prefix;
    private Integer accessExp;
    private Integer refreshExp;
}
