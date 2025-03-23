package com.vho.user_service.domain.repository;

import java.util.Optional;


import com.vho.user_service.domain.Person;

public interface UserRepository {

	Optional<Person> findByEmail(String email);
	Person save(Person person);
	
	
}
