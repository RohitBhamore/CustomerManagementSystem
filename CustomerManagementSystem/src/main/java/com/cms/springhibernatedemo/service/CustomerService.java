package com.cms.springhibernatedemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cms.springhibernatedemo.entity.Customer;

@Service
public interface CustomerService {

	public List<Customer> getCustomers();

	public Customer getCustomer(int theId);

	public void saveOrUpdateCustomer(Customer theCustomer);

	public void deleteCustomer(Customer theCustomer);
}
