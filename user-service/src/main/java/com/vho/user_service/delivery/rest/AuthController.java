package com.vho.user_service.delivery.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vho.user_service.application.usecase.AuthUseCase;
import com.vho.user_service.domain.Person;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthUseCase authUseCase;
	
	@PostMapping("/register")
	public String registerNewUser(@RequestBody Person person) {
		return authUseCase.saveUser(person);
	}
	
	
	@PostMapping("/token")
	public String getToken(@RequestBody Person person) {
		return authUseCase.generateToken(person.getEmail());
	}
	
	@GetMapping("/validate")
	public String validateToken(@RequestParam("token") String token) {
		authUseCase.validateToken(token);
		return "Valid Token";
	}
	
	
}
