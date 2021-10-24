package com.mbassignment.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

import com.mbassignment.model.Employee;
import com.mbassignment.model.Manager;

public interface EmployeeService {

	public Employee saveRecored(Employee employee);

	public Page<Employee> getAllEmployessByPagination(int id);

	public int deleteEmploye(int id);

	public Employee findEmployeeById(int id);

	public void updateEmployeeForm(Employee employee);

	public void common(int startPage, EmployeeService service, Model model);

}
