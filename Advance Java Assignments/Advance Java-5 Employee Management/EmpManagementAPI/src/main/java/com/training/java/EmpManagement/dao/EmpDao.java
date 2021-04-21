package com.training.java.EmpManagement.dao;

import org.springframework.data.repository.CrudRepository;

import com.training.java.EmpManagement.models.Employee;

public interface EmpDao extends CrudRepository<Employee, Integer> {
	
}
