package com.mbassignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbassignment.model.Manager;

public interface ManagerRepo extends JpaRepository <Manager, Integer>{

	
	public Manager findUserByEmail(String email);
}
