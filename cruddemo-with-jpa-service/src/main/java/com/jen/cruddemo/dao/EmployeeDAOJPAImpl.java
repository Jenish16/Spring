package com.jen.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jen.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {


	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJPAImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {

		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);

		List<Employee> employees = theQuery.getResultList();

		return employees;
	}

	@Override
	public Employee findById(int theId) {

		Employee theEmployee = entityManager.find(Employee.class, theId);

		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		Employee dbEmployee  = entityManager.merge(theEmployee);	
		
		theEmployee.setId(dbEmployee.getId());

	}

	@Override
	public void deleteById(int theId) {
		
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");

		theQuery.setParameter("employeeId", theId);

		theQuery.executeUpdate();
	}

}
