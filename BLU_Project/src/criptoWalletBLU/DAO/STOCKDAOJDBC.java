package criptoWalletBLU.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import criptoWalletBLU.CLASES.Moneda;


public class STOCKDAOJDBC implements StockDao {

	public int insertSTOCK(Moneda moneda, String tipo) {
		Connection coneccion = null;
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = (
					"INSERT INTO STOCK (NOMENCLATURA, PRECIO, CANTIDAD, NOMBRE, TIPO, VOLATILIDAD)"
					+"VALUES (" 
					+ "'"+moneda.getNomenclatura()+"'"+", "
					+ moneda.getPrecio()+", "
					+ moneda.getCantidad() + ", "
					+"'"+moneda.getNombre()+"', "
					+"'"+tipo+"', "
					+moneda.getVolatilidad()+");");
			int result = st.executeUpdate(sql);
			coneccion.close();
			st.close();
			return result;
		}
		catch(SQLException e) {
			System.out.println("ERROR EN METODO: insertSTOCK (clase STOCKDAOJDBC)");
			System.out.println(e.getMessage());
			return -1;
		}
	}

	public List<Moneda> selectSTOCK() {
		Connection coneccion = null;
		List<Moneda> listaStock = new ArrayList<Moneda>();
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = ("SELECT * FROM STOCK");
			ResultSet result = st.executeQuery(sql);
			while(result.next()) {
				listaStock.add(new Moneda(result.getDouble("PRECIO"),result.getDouble("CANTIDAD") , result.getString("NOMBRE"), result.getString("NOMENCLATURA"), result.getDouble("VOLATILIDAD")));
			}
			coneccion.close();
			st.close();
			return listaStock;
		}
		catch(SQLException e) {
			System.out.println("ERROR EN METODO: selectSTOCK (clase STOCKDAOJDBC)");
			System.out.println(e.getMessage());
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
			coneccion.close();
			st.close();
			return result;
		}
		catch(SQLException e) {
			System.out.println("ERROR EN METODO: contarSTOCK (clase STOCKDAOJDBC)");
			System.out.println(e.getMessage());
			return 0;
		}
	}

	public int updateCantidad(Moneda moneda) {
		Connection coneccion = null;
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = ("UPDATE STOCK "+
						"SET CANTIDAD = "+moneda.getCantidad()+
						" WHERE NOMENCLATURA='"+moneda.getNomenclatura()+"';");
			int result = st.executeUpdate(sql);
			coneccion.close();
			st.close();
			return result;
		}
		catch(SQLException e) {
			System.out.println("ERROR EN METODO: updateCantidad (clase STOCKDAOJDBC)");
			System.out.println(e.getMessage());
			return 0;
		}
	}

	public List<String> selectNomenclaturas() {
		Connection coneccion = null;
		List<String> listaNomenclaturas = new ArrayList<String>();
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = ("SELECT NOMENCLATURA FROM STOCK");
			ResultSet result = st.executeQuery(sql);
			while(result.next()) {
				listaNomenclaturas.add(result.getString("NOMENCLATURA"));
			}
			coneccion.close();
			st.close();
			return listaNomenclaturas;
		}
		catch(SQLException e) {
			System.out.println("ERROR EN METODO: selectNomenclaturas (clase STOCKDAOJDBC)");
			System.out.println(e.getMessage());
			return null;
		}
	}
	public List<String> selectNomenclaturasCripto() {
		Connection coneccion = null;
		List<String> listaCriptos = new ArrayList<String>();
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = ("SELECT NOMENCLATURA FROM STOCK WHERE TIPO='CRIPTO'");
			ResultSet result = st.executeQuery(sql);
			while(result.next()) {
				listaCriptos.add(result.getString("NOMENCLATURA"));
			}
			coneccion.close();
			st.close();
			return listaCriptos;
		}
		catch(SQLException e) {
			System.out.println("ERROR EN METODO: selectNomenclaturasCripto (clase STOCKDAOJDBC)");
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public List<Moneda> selectSTOCKCripto() {
		Connection coneccion = null;
		List<Moneda> listaStock = new ArrayList<Moneda>();
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = ("SELECT * FROM STOCK WHERE TIPO='CRIPTO'");
			ResultSet result = st.executeQuery(sql);
			while(result.next()) {
				listaStock.add(new Moneda(result.getDouble("PRECIO"),result.getDouble("CANTIDAD") , result.getString("NOMBRE"), result.getString("NOMENCLATURA"), result.getDouble("VOLATILIDAD")));
			}
			coneccion.close();
			st.close();
			return listaStock;
		}
		catch(SQLException e) {
			System.out.println("ERROR EN METODO: selectSTOCKCripto (clase STOCKDAOJDBC)");
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public List<String> selectNomenclaturasFiat() {
		Connection coneccion = null;
		List<String> listaFiats = new ArrayList<String>();
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = ("SELECT NOMENCLATURA FROM STOCK WHERE TIPO='FIAT'");
			ResultSet result = st.executeQuery(sql);
			while(result.next()) {
				listaFiats.add(result.getString("NOMENCLATURA"));
			}
			coneccion.close();
			st.close();
			return listaFiats;
		}
		catch(SQLException e) {
			System.out.println("ERROR EN METODO: selectNomenclaturasFiat (clase STOCKDAOJDBC)");
			System.out.println(e.getMessage());
			return null;
		}
	}
	public double selectPrecioNomenclatura(Moneda moneda) {
		Connection coneccion = null;
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = ("SELECT PRECIO FROM STOCK WHERE NOMENCLATURA='"+moneda.getNomenclatura()+"';");
			ResultSet result = st.executeQuery(sql);
			double resultado=result.getDouble("PRECIO");
			coneccion.close();
			st.close();
			return resultado;
		}
		catch(SQLException e) {
			System.out.println("ERROR EN METODO: selectPrecioNomenclatura (clase STOCKDAOJDBC)");
			System.out.println(e.getMessage());
			return 0;
		}
	}
	public double selectCantidadNomenclatura(Moneda moneda) {
		Connection coneccion = null;
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = ("SELECT CANTIDAD FROM STOCK WHERE NOMENCLATURA='"+moneda.getNomenclatura()+"';");
			ResultSet result = st.executeQuery(sql);
			double resultado = result.getDouble("CANTIDAD");
			coneccion.close();
			st.close();
			return resultado;
		}
		catch(SQLException e) {
			System.out.println("ERROR EN METODO: selectCantidadNomenclatura (clase STOCKDAOJDBC)");
			System.out.println(e.getMessage());
			return 0;
		}
	}
	
}
