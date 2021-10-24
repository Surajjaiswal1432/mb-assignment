package com.mbassignment.dao;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.mbassignment.model.Employee;
import com.mbassignment.model.Manager;

public interface EmployeeDao {

	public Employee saveRecored(Employee employee);

	public Page<Employee> getAllEmployessByPagination(PageRequest pages);

	public int deleteEmployeeById(int id);

	public Employee findEmployeeById(int id);

	public void updateEmployeeRecored(Employee employee);

}
