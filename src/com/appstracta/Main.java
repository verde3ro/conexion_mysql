package com.appstracta;

import com.appstracta.utils.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

	public static void main(String[] args) {
		Conexion conexion;

		try {
			conexion = new Conexion();
			String sql = "SELECT city_id, city, country_id, last_update FROM city WHERE city_id = ? ORDER BY city_id ASC";
			conexion.connectar();

			try (PreparedStatement ps = conexion.getConnection().prepareStatement(sql)) {
				ps.setLong(1, 90);

				try (ResultSet rs = ps.executeQuery()){
					while (rs.next()) {
						System.out.println("city_id :: " + rs.getInt("city_id") +
								", city :: " + rs.getString("city") +
								", country_id :: " + rs.getLong("country_id") +
								", last_update :: " + rs.getDate("last_update"));
					}
				}
			}

			conexion.cerrar();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
