package com.mbassignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbassignment.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
