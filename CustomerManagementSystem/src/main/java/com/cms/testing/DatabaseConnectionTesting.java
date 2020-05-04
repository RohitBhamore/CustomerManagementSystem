package com.cms.testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionTesting {

	final static String URL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
	final static String USER_NAME = "springstudent";
	final static String PASSWORD = "springstudent";

	public static void main(String[] args) {

		try {

			Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

			if(con != null) {
				System.out.println("CONNECTED" );
			}else {
				System.out.println("NOT CONNECTED");
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}

}
