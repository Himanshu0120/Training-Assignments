package com.training.java.EmpManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.java.EmpManagement.models.Employee;
import com.training.java.EmpManagement.service.EmpService;

@RestController
public class MainController {
	@Autowired
	private EmpService service;
	
	@GetMapping("/")
	public String home() {
		return "this is homepage";
	}
	
	@GetMapping("/all")
	public List<Employee> getEmployees(){
		return service.getAll();
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable String id) {
		return service.getEmp(Integer.parseInt(id));
	}
	
	@PostMapping("/add")
	public void add(@RequestBody Employee emp) {
		service.addEmp(emp);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Employee emp) {
		service.update(emp);
	}
}
