package com.vho.user_service.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "DNI")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryPerson extends Person{
	
	private String AssignedVehicle;
	
}
