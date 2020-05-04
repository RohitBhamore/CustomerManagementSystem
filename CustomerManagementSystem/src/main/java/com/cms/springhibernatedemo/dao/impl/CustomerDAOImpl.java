package com.cms.springhibernatedemo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cms.springhibernatedemo.dao.CustomerDAO;
import com.cms.springhibernatedemo.entity.Customer;

@Repository(value = "CustomerDAO")
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory factory;

	@SuppressWarnings("finally")
	@Transactional
	public List<Customer> getCustomers() {

		String LIST_DATA_SQL = "from Customer";
		Session session;
		Query<Customer> query;
		List<Customer> theStudent = null;

		try {
			session = factory.getCurrentSession();

			query = session.createQuery(LIST_DATA_SQL, Customer.class);

			theStudent = query.getResultList();

		} catch (Exception ex) {
			System.out.println("Getting error in getCustomer:" + ex.getMessage());
		} finally {
			return theStudent;
		}
	}

	@SuppressWarnings("finally")
	@Override
	@Transactional
	public Customer getCustomer(int theId) {

		Session session;
		Customer theCustomer = null;

		try {
			session = factory.getCurrentSession();
			theCustomer = session.get(Customer.class, theId);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

			return theCustomer;
		}

	}

	@Override
	@Transactional
	public void saveOrUpdateCustomer(Customer theCustomer) {

		Session session;

		try {

			session = factory.getCurrentSession();
			session.saveOrUpdate(theCustomer);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void deleteCustomer(Customer theCustomer) {

		Session session;

		try {

			session = factory.getCurrentSession();
			session.delete(theCustomer);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
