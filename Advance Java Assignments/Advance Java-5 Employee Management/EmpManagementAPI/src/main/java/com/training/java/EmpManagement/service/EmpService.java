package com.training.java.EmpManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.java.EmpManagement.models.Employee;

import com.training.java.EmpManagement.dao.EmpDao;

@Service
public class EmpService {
	
	@Autowired
	private EmpDao empdao;
	
	public List<Employee> getAll(){
		return (List<Employee>) empdao.findAll();
	}
	
	public Employee getEmp(int id) {
		List<Employee> list=(List<Employee>) empdao.findAll();
		for(Employee emp:list) {
			if(emp.getEmpId()==id)
				return emp;
		}
		return null;
	}
	
	public void addEmp(Employee emp) {
		empdao.save(emp);
	}
	
	public void update(Employee emp) {
		empdao.save(emp);
	}
	
	
}
