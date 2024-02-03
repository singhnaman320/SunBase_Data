package com.example.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cms.exception.CustomerNotFoundException;
import com.example.cms.model.Customer;
import com.example.cms.service.CustomerService;

import jakarta.validation.Valid;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> registerEmployeeHandler(@Valid @RequestBody Customer customer) throws CustomerNotFoundException{
		
		Customer saveCustomer = customerService.registerCustomer(customer);
		
		return new ResponseEntity<Customer>(saveCustomer, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/customers/{Id}")
	public ResponseEntity<Customer> getEmployeeByIdHandler(@PathVariable("Id") Integer empId) throws CustomerNotFoundException{
		
		Customer customer = customerService.getCustomerById(empId);
		
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@GetMapping(value = "/customers")
	public ResponseEntity<List<Customer>> getAllEmployeeDetailsHandler() throws CustomerNotFoundException{
		
		List<Customer> customersList= customerService.getAllCustomerDetails();
		
		return new ResponseEntity<List<Customer>>(customersList, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value = "/customers/{Id}")
	public ResponseEntity<Customer> deleteEmployeeByIdHandler(@PathVariable("Id") Integer customerId) throws CustomerNotFoundException{
		
		Customer deleteCustomer= customerService.deleteCustomerById(customerId);
		
		return new ResponseEntity<Customer>(deleteCustomer, HttpStatus.OK);
	}
	
	@PutMapping("/customers")
	public ResponseEntity<Customer> updateCustomersHandler(@Valid @RequestBody Customer customer) throws CustomerNotFoundException{
		
		Customer updateCustomer = customerService.updateCustomer(customer);
		
		return new ResponseEntity<Customer>(updateCustomer, HttpStatus.ACCEPTED);
	}
	
}
