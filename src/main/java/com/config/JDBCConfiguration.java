package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;

public class JDBCConfiguration {

	@Bean
	public static Connection connexion() {
		try {
			return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "poladrien", "root");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}