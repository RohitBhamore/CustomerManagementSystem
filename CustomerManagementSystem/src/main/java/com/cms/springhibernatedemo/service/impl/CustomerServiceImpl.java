package com.cms.springhibernatedemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.springhibernatedemo.dao.CustomerDAO;
import com.cms.springhibernatedemo.entity.Customer;
import com.cms.springhibernatedemo.service.CustomerService;

@Service(value = "CustomerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDao;

	@Override
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

	@Override
	public Customer getCustomer(int theId) {
		return customerDao.getCustomer(theId);
	}

	@Override
	public void saveOrUpdateCustomer(Customer theCustomer) {
		customerDao.saveOrUpdateCustomer(theCustomer);
	}

	@Override
	public void deleteCustomer(Customer theCustomer) {
		customerDao.deleteCustomer(theCustomer) ;
	}

}
