package com.vho.user_service.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "DNI") // indico que cliente tiene como llave primaria una llave foranea que hace referencia a DNI en User
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client extends Person {
	
	private int age;
	private String phone;
	private String gender;
	private String address;
	
	
}
