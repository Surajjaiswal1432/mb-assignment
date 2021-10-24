package com.mbassignment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mbassignment.model.Manager;
import com.mbassignment.repo.ManagerRepo;

@Service
public class ManagerDetailServiceImpl implements UserDetailsService {

	@Autowired
	private ManagerRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Manager manager = repo.findUserByEmail(username);

		if (manager == null) {

			throw new UsernameNotFoundException("Could not found");
		}
		CustomUserDetails customUserDetails = new CustomUserDetails(manager);

		return customUserDetails;
	}

}
