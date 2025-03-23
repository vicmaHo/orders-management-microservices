package com.vho.user_service.infraestructure.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vho.user_service.domain.Person;
import com.vho.user_service.domain.repository.UserRepository;


public interface UserCredentialRepositoryImpl extends JpaRepository<Person, Integer>, UserRepository{
	
	@Override
	Optional<Person> findByEmail(String email);
}
