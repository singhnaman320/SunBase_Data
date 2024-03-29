package com.example.cms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cms.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	// For Signin
	public Optional<Customer> findByEmail(String email);
}
