package com.hexaware.cars.dao;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class DBUtil {
	public static Connection getDBConnection() throws SQLException {// Factory method

		FileReader fr = null;
		Properties prop =null ;
		try {
			fr = new FileReader("src/Database.properties");
			
			prop = new Properties();

			prop.load(fr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		String url = prop.getProperty("jdbc:mysql://localhost:3306/cars");

		String username = prop.getProperty("root");

		String password = prop.getProperty("Vins@5545");

		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "Vins@5545");

		return conn;

	}
}
