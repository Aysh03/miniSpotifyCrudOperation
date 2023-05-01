package com.example.loginauthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LoginAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginAuthenticationApplication.class, args);
	}
}
