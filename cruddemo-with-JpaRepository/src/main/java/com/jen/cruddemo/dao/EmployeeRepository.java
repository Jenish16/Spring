package com.jen.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jen.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
