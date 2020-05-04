package com.cms.springhibernatedemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cms.springhibernatedemo.entity.Customer;

@Repository
public interface CustomerDAO {

	public List<Customer> getCustomers();

	public Customer getCustomer(int theId);

	public void saveOrUpdateCustomer(Customer theCustomer);

	public void deleteCustomer(Customer theCustomer);

}
