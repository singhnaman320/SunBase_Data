package com.example.cms.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
	 
	 @NotNull
	 @NotBlank
	 @Size(min = 2, max = 20, message = "FirstName should have 2 to 20 characters")
	 private String firstName;
	 
	 @NotNull
	 @NotBlank
	 @Size(min = 2, max = 20, message = "FirstName should have 2 to 20 characters")
	 private String lastName;
	 
	 @NotNull
	 @NotBlank
	 private String street;
	 
	 @NotNull
	 @NotBlank
	 private String address;
	 
	 @NotNull
	 @NotBlank
	 private String city;
	 
	 @NotNull
	 @NotBlank
	 private String state;
	 
	 @Column(unique = true)
	 @NotNull
	 @NotBlank
	 private String email;
	 
	 @Column(unique = true)
	 @NotNull
	 @NotBlank
	 private String phone;
	 
	 @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	 private String password;
	 
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer",fetch=FetchType.EAGER)
	 private List<Authority> authorities = new ArrayList<>();
		
}
