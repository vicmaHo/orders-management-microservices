package com.vho.user_service.application.usecase;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vho.user_service.domain.Person;
import com.vho.user_service.domain.repository.UserRepository;
import com.vho.user_service.infraestructure.security.JwtService;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class AuthUseCase {
	
	
	private final UserRepository repository;
	private final PasswordEncoder encoder;
	private final JwtService jwtService;
	
	public String saveUser(Person person) {
		
		person.setPassword(encoder.encode(person.getPassword()));
		
		repository.save(person);
		return "user saved";
	}
	
	public String generateToken(String username) {
		return jwtService.generateToken(username);
	}
	
	public void validateToken(String token) {
		jwtService.validateToken(token);
	}
	
	
	

	

}
