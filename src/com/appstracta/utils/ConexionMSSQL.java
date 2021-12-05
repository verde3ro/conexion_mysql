package com.appstracta.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMSSQL {

	private Connection connection;
	private static final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=DBTEST01";
	private static final String USER = "test";
	private static final String PASSWORD = "123456789";

	public void connectar() {
		try {
			this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void cerrar() {
		if (this.connection != null) {
			try {
				this.connection.close();
			} catch (SQLException ex ) {
				ex.printStackTrace();
			}
		}
	}

	public Connection getConnection() {
		return connection;
	}

}
