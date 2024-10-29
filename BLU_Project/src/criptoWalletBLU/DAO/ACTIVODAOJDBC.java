package criptoWalletBLU.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import criptoWalletBLU.CLASES.Moneda;

public class ACTIVODAOJDBC implements ACTIVODAO {

	public int insertACTIVO(int idusuario, Moneda moneda) {
		Connection coneccion = null;
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = (
					"INSERT INTO ACTIVOS (IDUSUARIO, CANTIDAD, NOMENCLATURA)"
					+"VALUES (" 
					+ idusuario+", "
					+ moneda.getCantidad()+", "
					+"'"+moneda.getNomenclatura()+"');");
			int result = st.executeUpdate(sql);
			coneccion.close();
			st.close();
			return result;
		}
		catch(SQLException e) {
			System.out.println("ERROR EN METODO: insertACTIVO (clase ACTIVODAOJDBC)");
			System.out.println(e.getMessage());
			return -1;
		}
	}
	
	public List<Moneda> selectACTIVOS(int idusuario) {
		Connection coneccion = null;
		List<Moneda> listaActivos = new ArrayList<Moneda>();
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = ("SELECT * FROM ACTIVOS WHERE IDUSUARIO="+idusuario+";");
			ResultSet result = st.executeQuery(sql);
			while(result.next()) {
				listaActivos.add(new Moneda(0,result.getDouble("CANTIDAD") ,"", result.getString("NOMENCLATURA"),0));
			}
			coneccion.close();
			st.close();
			return listaActivos;
		}
		catch(SQLException e) {
			System.out.println("ERROR EN METODO: selectACTIVOS (clase ACTIVODAOJDBC)");
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public List<String> selectNomenclaturas(int idusuario) {
		Connection coneccion = null;
		List<String> listaNomenclaturas = new ArrayList<String>();
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = ("SELECT NOMENCLATURA FROM ACTIVOS WHERE IDUSUARIO="+idusuario+";");
			ResultSet result = st.executeQuery(sql);
			while(result.next()) {
				listaNomenclaturas.add(result.getString("NOMENCLATURA"));
			}
			coneccion.close();
			st.close();
			return listaNomenclaturas;
		}
		catch(SQLException e) {
			System.out.println("ERROR EN METODO: selectNomenclaturas (clase ACTIVODAOJDBC)");
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public int updateCantidad(int idusuario, Moneda moneda) {
		Connection coneccion = null;
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = ("UPDATE ACTIVOS "+
						"SET CANTIDAD = "+moneda.getCantidad()+
						" WHERE NOMENCLATURA='"+moneda.getNomenclatura()+"' AND IDUSUARIO = "+idusuario+";");
			int resultado = st.executeUpdate(sql);
			coneccion.close();
			st.close();
			return resultado;
		}
		catch(SQLException e) {
			System.out.println("ERROR EN METODO: updateCantidad (clase ACTIVODAOJDBC)");
			System.out.println(e.getMessage());
			return -1;
		}
	}
	
	public double selectCantidadNomenclatura(Moneda moneda) {
		Connection coneccion = null;
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = ("SELECT CANTIDAD FROM ACTIVOS WHERE NOMENCLATURA='"+moneda.getNomenclatura()+"';");
			ResultSet result = st.executeQuery(sql);
			double resultado=result.getDouble("CANTIDAD");
			coneccion.close();
			st.close();
			return resultado;
		}
		catch(SQLException e) {
			System.out.println("ERROR EN METODO: selectCantidadNomenclatura (clase ACTIVODAOJDBC)");
			System.out.println(e.getMessage());
			return -1;
		}
	}

}
