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
			int result = st.executeUpdate(sql);
			System.out.println("Operacion exitosa.");
			return result;
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
			ResultSet result = st.executeQuery(sql);
			return result;
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
			int result = st.executeQuery(sql).getInt(1);
			return result;
		}
		catch(SQLException e) {
			System.out.println("no se pudo conectar a la BD.");
			return 0;
		}
	}

	public int updateCantidad(String nomenclatura, double cantidad) {
		Connection coneccion = null;
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = ("UPDATE STOCK "+
						"SET CANTIDAD = "+cantidad+
						" WHERE NOMENCLATURA='"+nomenclatura+"';");
			return st.executeUpdate(sql);
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	public ResultSet selectNomenclaturas() {
		Connection coneccion = null;
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = ("SELECT NOMENCLATURA FROM STOCK");
			ResultSet result = st.executeQuery(sql);
			return result;
		}
		catch(SQLException e) {
			System.out.println("no se pudo conectar a la BD."+e.getMessage());
			return null;
		}
	}
	public ResultSet selectNomenclaturasCripto() {
		Connection coneccion = null;
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = ("SELECT NOMENCLATURA FROM STOCK WHERE TIPO='CRIPTO'");
			ResultSet result = st.executeQuery(sql);
			return result;
		}
		catch(SQLException e) {
			System.out.println("no se pudo conectar a la BD."+e.getMessage());
			return null;
		}
	}
	public ResultSet selectNomenclaturasFiat() {
		Connection coneccion = null;
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = ("SELECT NOMENCLATURA FROM STOCK WHERE TIPO='FIAT'");
			ResultSet result = st.executeQuery(sql);
			return result;
		}
		catch(SQLException e) {
			System.out.println("no se pudo conectar a la BD."+e.getMessage());
			return null;
		}
	}
	public ResultSet selectPrecioNomenclatura(String nomenclatura) {
		Connection coneccion = null;
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = ("SELECT PRECIO FROM STOCK WHERE NOMENCLATURA='"+nomenclatura+"';");
			ResultSet result = st.executeQuery(sql);
			return result;
		}
		catch(SQLException e) {
			System.out.println("no se pudo conectar a la BD."+e.getMessage());
			return null;
		}
	}
	public ResultSet selectCantidadNomenclatura(String nomenclatura) {
		Connection coneccion = null;
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = ("SELECT CANTIDAD FROM STOCK WHERE NOMENCLATURA='"+nomenclatura+"';");
			ResultSet result = st.executeQuery(sql);
			return result;
		}
		catch(SQLException e) {
			System.out.println("no se pudo conectar a la BD."+e.getMessage());
			return null;
		}
	}
	
}
