package com.amin.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;



public class TestJDBC {

	public static void main(String[] args) {
	
		
		String jdbcURL = "jdbc:mysql://localhost:3306/hb_student_tracker";
		String login = "hbstudent";
		String password = "hbstudent";
		
	
		try {
			System.out.println("Connection to the Datbase :"+ jdbcURL);
			Connection mySqlConnection = DriverManager.getConnection(jdbcURL,login,password);
			
			System.out.println("Connection is DONE :" + mySqlConnection.getSchema());
			
		}catch (Exception exception) {
			System.out.println("Failed Connection");
		}

	}

}
