package com.cms.springhibernatedemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	/*
	
	//customer table
	------------+-------------+------+-----+---------+----------------+
	| Field      | Type        | Null | Key | Default | Extra          |
	+------------+-------------+------+-----+---------+----------------+
	| id         | int(11)     | NO   | PRI | NULL    | auto_increment |
	| first_name | varchar(45) | YES  |     | NULL    |                |
	| last_name  | varchar(45) | YES  |     | NULL    |                |
	| email      | varchar(45) | YES  |     | NULL    |                |
	+------------+-------------+------+-----+---------+----------------+
	
	*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstNmae;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String firstNmae, String lastName, String email) {
		super();
		this.firstNmae = firstNmae;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstNmae() {
		return firstNmae;
	}

	public void setFirstNmae(String firstNmae) {
		this.firstNmae = firstNmae;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstNmae=" + firstNmae + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
}
