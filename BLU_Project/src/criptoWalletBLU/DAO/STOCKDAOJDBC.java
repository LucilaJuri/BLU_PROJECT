package criptoWalletBLU.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class STOCKDAOJDBC implements STOCKDAO {

	public int insertSTOCK(String nomenclatura, double dolar, double stock, String nombre, String tipo) {
		Connection coneccion = null;
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = (
					"INSERT INTO STOCK (NOMENCLATURA, PRECIO, CANTIDAD, NOMBRE, TIPO)"
					+"VALUES (" 
					+ "'"+nomenclatura+"'"+", "
					+ dolar+", "
					+ stock + ", "
					+"'"+nombre+"', "
					+"'"+tipo+"');");
			int ret = st.executeUpdate(sql);
			System.out.println("Operacion exitosa.");
			st.close();
			coneccion.close();
			return ret;
		}
		catch(SQLException e) {
			System.out.println("no se pudo conectar a la BD.");
			return -1;
		}
	}

	public ResultSet selectSTOCK() {
		Connection coneccion = null;
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = ("SELECT * FROM STOCK");
			return st.executeQuery(sql);
		}
		catch(SQLException e) {
			System.out.println("no se pudo conectar a la BD.");
			return null;
		}
	}
	
	public int contarSTOCK() {
		Connection coneccion = null;
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = ("SELECT COUNT(*) FROM STOCK");
			return st.executeQuery(sql).getInt(1);
		}
		catch(SQLException e) {
			System.out.println("no se pudo conectar a la BD.");
			return 0;
		}
	}

	@Override
	public int updateCantidad(int i, double cantidad) {
		Connection coneccion = null;
		System.out.println(cantidad);
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = ("UPDATE STOCK "+
						"SET CANTIDAD = "+cantidad+
						" WHERE id = "+i+";");
			return st.executeUpdate(sql);
		}
		catch(SQLException e) {
			System.out.println("no se pudo conectar a la BD."+e.getMessage());
			return 0;
		}
	}
	
}
