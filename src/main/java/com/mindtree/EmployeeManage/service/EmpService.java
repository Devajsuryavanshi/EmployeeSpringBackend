package com.mindtree.EmployeeManage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mindtree.EmployeeManage.entity.Employee;
import com.mindtree.EmployeeManage.repository.EmployeeRepository;

@Component
public class EmpService {
	
	@Autowired
	EmployeeRepository repo;
	
	public Employee getEmployeeById(int id) {	
		Employee emp = repo.findById(id).get();
		return emp;
	}
	
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}
	
	public void addorUpdateEmployee(Employee emp) {
		repo.save(emp);
	}
	
	public void deleteEmployee(int id) {
		repo.deleteById(id);
	}

}
