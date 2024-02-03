package com.example.cms.service;

import java.util.Collection;
import java.util.List;
import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.cms.model.Authority;
import com.example.cms.model.Customer;

public class CustomerUserDetails implements UserDetails{

	Customer customer;
	
	public CustomerUserDetails(Customer customer) {
		this.customer = customer;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Collection<GrantedAuthority> authorities = new ArrayList<>();
		
		List<Authority> auths= customer.getAuthorities();
		
		for(Authority auth:auths) {
			SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(auth.getName());
			authorities.add(simpleGrantedAuthority);
		}
		
		
		return authorities;
		
	}

	@Override
	public String getPassword() {
		
		return customer.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return customer.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		
		// Does not required to be implemented here
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		
		// Does not required to be implemented here
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		
		// Does not required to be implemented here
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		
		// Does not required to be implemented here
		return true;
	}
}
