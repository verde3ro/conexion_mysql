package com.appstracta;

import com.appstracta.utils.ConexionMSSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainMSSQL {

	public static void main(String[] args) {
		ConexionMSSQL conexion;

		try {
			conexion = new ConexionMSSQL();
			String sql = "SELECT CITY_ID, CITY, COUNTRY_ID, LAST_UPDATE FROM CITY ORDER BY CITY_ID ASC";
			conexion.connectar();

			try (PreparedStatement ps = conexion.getConnection().prepareStatement(sql);
			     ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					System.out.println("CITY_ID :: " + rs.getInt("CITY_ID") +
							", CITY :: " + rs.getString("CITY") +
							", COUNTRY_ID :: " + rs.getLong("COUNTRY_ID") +
							", LAST_UPDATE :: " + rs.getDate("LAST_UPDATE"));
				}
			}

			conexion.cerrar();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


}
