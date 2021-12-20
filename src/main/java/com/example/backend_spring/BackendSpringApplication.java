package com.example.backend_spring;

import java.util.ArrayList;

import com.example.backend_spring.models.Role;
import com.example.backend_spring.models.User;
import com.example.backend_spring.services.UserService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BackendSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendSpringApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));

			userService.saveUser(new User(null, "Muhammad Fatih", "admin", "1234", "085786897544", new ArrayList<>()));
			userService.saveUser(new User(null, "Farkhan Hasani", "user01", "1234", "089577210236", new ArrayList<>()));

			userService.addRoleToUser("admin", "ROLE_ADMIN");
			userService.addRoleToUser("user01", "ROLE_USER");

			// userService.updatePhoneNumberUser("0857868975", "admin");
		};
	}

}
