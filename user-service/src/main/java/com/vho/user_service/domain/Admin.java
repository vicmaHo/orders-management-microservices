package com.vho.user_service.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "DNI")
@Setter
@Getter
public class Admin extends Person{

	
}
