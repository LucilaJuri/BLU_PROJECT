package criptoWalletBLU.SINGLETONS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConexiones {
	private static Connection conexion;

	static {
		try {
			conexion = DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: SingletonConexiones (clase SingletonConexiones)");
			System.out.println(e.getMessage());
		}
	}

	private SingletonConexiones() {
	}

	public static Connection getConexion() {
		return conexion;
	}

	public static void deleteConexion() {
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: deleteConexion (clase SingletonConexiones)");
			System.out.println(e.getMessage());
		}
	}
}
