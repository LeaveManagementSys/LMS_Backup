package com.virtusa.integrate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {


	private static DataSource dataSource=new DataSource();
	
	private static Connection connection=null;
	public static Connection openConnection() throws ClassNotFoundException,SQLException {
		
		Class.forName(dataSource.getDriver());
		connection=DriverManager.getConnection(dataSource.getUrl(),dataSource.getUsername(),dataSource.getPassword());
		return connection;
	}//creating connection to database to store information
	
	public static void closeConnection() throws SQLException{
		
		connection.close();
	}
	//close connection to database
	
}
