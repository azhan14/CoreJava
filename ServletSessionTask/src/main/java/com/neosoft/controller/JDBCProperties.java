package com.neosoft.controller;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCProperties {
	static String driverClass = null;
	static String url = null;
	static String username = null;
	static String password = null;
	static Connection con;
	
	public static void loadProperties(){
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\user\\git\\JavaLab\\ServletSessionTask\\resources\\database.properties");
			Properties prop = new Properties();
			prop.load(fis);
			driverClass = prop.getProperty("MySQLJdbc.driver");
			url = prop.getProperty("MySQLJdbc.url");
			username = prop.getProperty("MySQLJdbc.user");
			password = prop.getProperty("MySQLJdbc.pass");
			prop.clear();
			fis.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			loadProperties();
			Class.forName(driverClass);
			con = DriverManager.getConnection(url,username,password);
			System.out.println("Connection Established...");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
