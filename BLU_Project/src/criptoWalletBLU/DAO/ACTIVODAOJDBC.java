package criptoWalletBLU.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ACTIVODAOJDBC implements ACTIVODAO {

	public int instertACTIVO(int idusuario, double cantidad, String nomenclatura) {
		Connection coneccion = null;
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = (
					"INSERT INTO ACTIVOS (IDUSUARIO, CANTIDAD, NOMENCLATURA)"
					+"VALUES (" 
					+ idusuario+", "
					+ cantidad+", "
					+"'"+nomenclatura+"');");
			int result = st.executeUpdate(sql);
			System.out.println("Operacion exitosa.");
			return result;
		}
		catch(SQLException e) {
			System.out.println("no se pudo conectar a la BD.");
			return -1;
		}
	}
	
	public ResultSet selectACTIVOS(int idusuario) {
		Connection coneccion = null;
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = ("SELECT * FROM ACTIVOS WHERE IDUSUARIO="+idusuario+";");
			ResultSet result = st.executeQuery(sql);
			return result;
		}
		catch(SQLException e) {
			System.out.println("no se pudo conectar a la BD.");
			return null;
		}
	}
	
	public ResultSet selectNomenclaturas(int idusuario) {
		Connection coneccion = null;
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = ("SELECT NOMENCLATURA, CANTIDAD FROM ACTIVOS WHERE IDUSUARIO="+idusuario+";");
			ResultSet result = st.executeQuery(sql);
			return result;
		}
		catch(SQLException e) {
			System.out.println("no se pudo conectar a la BD."+e.getMessage());
			return null;
		}
	}
	
	public int updateCantidad(String nomenclatura, double cantidad, int idusuario) {
		Connection coneccion = null;
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = ("UPDATE ACTIVOS "+
						"SET CANTIDAD = "+cantidad+
						" WHERE NOMENCLATURA='"+nomenclatura+"' AND IDUSUARIO = "+idusuario+";");
			return st.executeUpdate(sql);
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

}
