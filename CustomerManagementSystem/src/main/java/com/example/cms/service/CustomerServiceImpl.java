package com.example.cms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cms.exception.CustomerNotFoundException;
import com.example.cms.model.Authority;
import com.example.cms.model.Customer;
import com.example.cms.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer registerCustomer(Customer customer) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		
		List<Authority> authorities= customer.getAuthorities();
		
		for(Authority authority:authorities) {
			
			authority.setCustomer(customer);;
		}
		
		return customerRepository.save(customer);

	}

	@Override
	public Customer getCustomerById(Integer customerId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		
		return customerRepository.findById(customerId).orElseThrow(()-> new CustomerNotFoundException("Customer does not exist with this Id"));

	}

	@Override
	public List<Customer> getAllCustomerDetails() throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		
		List<Customer> customers = customerRepository.findAll();
		
		if(customers.isEmpty()) {
			
			throw new CustomerNotFoundException("Unable to find details of all the customers");
		}
		return customers;
		
	}

	@Override
	public Customer deleteCustomerById(Integer customerId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Customer> opt = customerRepository.findById(customerId);
		
		if(opt.isPresent()) {
			
			Customer existingCustomer= opt.get();
			customerRepository.delete(existingCustomer);
			
			return existingCustomer;
			
		}else {
			
			throw new CustomerNotFoundException("Unable to delete customer with given customerId");
		}
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Customer> opt = customerRepository.findById(customer.getCustomerId());
		
		if(opt.isPresent()) {
			
			Customer updatedCustomer = customerRepository.save(customer);
			
			return updatedCustomer;
			
		}else {
			
			throw new CustomerNotFoundException("Unable to update customer details with given Id");
		}
	}

}
 