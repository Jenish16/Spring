package com.jen.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jen.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//Need to inject Session Factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get Current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Create Query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName",Customer.class);
		
		//Execute Query
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(theCustomer);
		
	}

}
