package com.example.cms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Customer {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer customerId;
	 private String firstName;
	 private String lastName;
	 private String street;
	 private String address;
	 private String city;
	 private String state;
	 private String email;
	 private String phone;
}
