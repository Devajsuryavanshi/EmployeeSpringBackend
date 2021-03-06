package com.mindtree.EmployeeManage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.EmployeeManage.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
