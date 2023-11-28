package com.withsafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.security.SecureRandom;
import java.util.Base64;

@SpringBootApplication
@EnableJpaAuditing // JPA Auditing 활성화
public class DemoApplication {
	public static void main(String[] args) {
//		SecureRandom secureRandom = new SecureRandom();
//		byte[] keyBytes = new byte[64];
//		secureRandom.nextBytes(keyBytes);
//
//		String secretKey = Base64.getEncoder().encodeToString(keyBytes);
//		System.out.println("Generated 64-byte JWT Secret Key: " + secretKey);
		SpringApplication.run(DemoApplication.class, args);
	}

}
