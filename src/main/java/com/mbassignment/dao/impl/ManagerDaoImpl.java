package com.mbassignment.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mbassignment.dao.ManagerDao;
import com.mbassignment.model.Manager;
import com.mbassignment.repo.ManagerRepo;

@Repository
public class ManagerDaoImpl implements ManagerDao {

	@Autowired
	private ManagerRepo repo;

	@Override
	public Manager registerInformation(Manager manager) {
		return repo.save(manager);
	}

	@Override
	public Manager findByEmail(String email) {

		return repo.findUserByEmail(email);
	}

}
