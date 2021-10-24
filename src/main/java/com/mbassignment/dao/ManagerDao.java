package com.mbassignment.dao;

import com.mbassignment.model.Manager;

public interface ManagerDao {

	public Manager registerInformation(Manager manager);


	public Manager findByEmail(String email);

}
