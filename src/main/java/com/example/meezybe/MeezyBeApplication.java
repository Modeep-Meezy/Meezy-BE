package com.example.meezybe;

import com.example.meezybe.infrastructure.global.security.jwt.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(JwtProperties.class)
public class MeezyBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeezyBeApplication.class, args);
	}

}
