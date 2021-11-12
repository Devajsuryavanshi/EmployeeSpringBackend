package com.mindtree.EmployeeManage.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mindtree.EmployeeManage.entity.Employee;
import com.mindtree.EmployeeManage.service.EmpService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmpService service;
	
	@GetMapping("/home")
	public String hello() {
		return "Welcome Home Buddy!";
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/employees")
	public List<Employee> allEmployees(){
		return service.getAllEmployees();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/employees/{id}")
	public Employee getById(@PathVariable int id){
		return service.getEmployeeById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/employees")
	public ResponseEntity<Void> addEmployee(@RequestBody Employee emp){
		
		service.addorUpdateEmployee(emp);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(emp.getId()).toUri();
        return ResponseEntity.created(location).build();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/employees")
	public ResponseEntity<Void> updateEmployee(@RequestBody Employee emp){
		
		service.addorUpdateEmployee(emp);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(emp.getId()).toUri();
        return ResponseEntity.created(location).build();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id) {
		service.deleteEmployee(id);
	}

}
