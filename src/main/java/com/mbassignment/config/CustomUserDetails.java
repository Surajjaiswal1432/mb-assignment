package com.mbassignment.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mbassignment.model.Manager;

public class CustomUserDetails implements UserDetails {
	
	

	private Manager manager;
	
	

	public CustomUserDetails(Manager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority  simpleGrantedAuthority = new SimpleGrantedAuthority(manager.getRole());
		
		return List.of(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {

		return manager.getPassword();
	}

	@Override
	public String getUsername() {

		return manager.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}
