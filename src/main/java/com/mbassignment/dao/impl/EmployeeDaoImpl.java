package com.mbassignment.dao.impl;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.mbassignment.dao.EmployeeDao;
import com.mbassignment.model.Employee;
import com.mbassignment.model.Manager;
import com.mbassignment.repo.EmployeeRepo;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EmployeeRepo repo;

	@Override
	public Employee saveRecored(Employee employee) {

		return repo.save(employee);
	}

	@Override
	public Page<Employee> getAllEmployessByPagination(PageRequest pages) {

		return repo.findAll(pages);
	}

	@Override
	public int deleteEmployeeById(int id) {

		repo.deleteById(id);
		;
		return id;
	}

	@Override
	public Employee findEmployeeById(int id) {

		return repo.getById(id);
	}

	@Override
	public void updateEmployeeRecored(Employee employee) {
		repo.save(employee);

	}

}
