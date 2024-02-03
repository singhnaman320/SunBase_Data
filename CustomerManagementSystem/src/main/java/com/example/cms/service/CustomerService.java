package com.example.cms.service;

import java.util.List;

import com.example.cms.exception.CustomerNotFoundException;
import com.example.cms.model.Customer;

public interface CustomerService {
	
	public Customer registerCustomer(Customer customer)throws CustomerNotFoundException;
	
	public Customer getCustomerById(Integer customerId)throws CustomerNotFoundException;
	
	public List<Customer> getAllCustomerDetails()throws CustomerNotFoundException;
	
	public Customer deleteCustomerById(Integer customerId)throws CustomerNotFoundException;
	
	public Customer updateCustomer(Customer customer)throws CustomerNotFoundException;
}
