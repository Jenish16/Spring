package com.jen.springdemo.dao;

import java.util.List;

import com.jen.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
}
