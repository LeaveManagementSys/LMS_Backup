package com.virtusa.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Test;

import com.virtusa.integrate.ConnectionManager;

public class TestConnection {

	
	@Test
	public void test() {
		try {
			Connection connection=ConnectionManager.openConnection();
			assertEquals(true,connection!=null);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			assertTrue(false);
		}	
	}

}
