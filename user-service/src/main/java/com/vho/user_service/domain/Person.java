package com.vho.user_service.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // estrategia de herencia para las tablas que derivan
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

	@Id
	private int DNI;
	
	private String name;
	private String email;
	private String password;
	private String role;
	
}
