package criptoWalletBLU.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import criptoWalletBLU.CLASES.Moneda;
import criptoWalletBLU.SINGLETONS.SingletonConexiones;

public class ActivoDaoJDBC implements ActivoDao {

	public int crearTablaActivos() {
		Connection coneccion = null;
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("CREATE TABLE IF NOT EXISTS \"ACTIVOS\" (\r\n" + "	\"DIRECCION\"	INTEGER UNIQUE,\r\n"
					+ "	\"IDUSUARIO\"	INTEGER NOT NULL,\r\n" + "	\"CANTIDAD\"	REAL NOT NULL,\r\n"
					+ "	\"NOMENCLATURA\"	TEXT NOT NULL UNIQUE,\r\n"
					+ "	PRIMARY KEY(\"DIRECCION\" AUTOINCREMENT)\r\n" + ");");
			int result = st.executeUpdate(sql);
			st.close();
			return result;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: crearTablaActivos (clase ActivoDaoJDBC)");
			System.out.println(e.getMessage());
			return -1;
		}
	}

	public int insertActivo(int idusuario, Moneda moneda) {
		Connection coneccion = null;
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("INSERT INTO ACTIVOS (IDUSUARIO, CANTIDAD, NOMENCLATURA)" + "VALUES (" + idusuario + ", "
					+ moneda.getCantidad() + ", " + "'" + moneda.getNomenclatura() + "');");
			int result = st.executeUpdate(sql);
			st.close();
			return result;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: insertACTIVO (clase ActivoDaoJDBC)");
			System.out.println(e.getMessage());
			return -1;
		}
	}

	public List<Moneda> selectActivos(int idusuario) {
		Connection coneccion = null;
		List<Moneda> listaActivos = new ArrayList<Moneda>();
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("SELECT * FROM ACTIVOS WHERE IDUSUARIO=" + idusuario + ";");
			ResultSet result = st.executeQuery(sql);
			while (result.next()) {
				listaActivos.add(new Moneda(result.getString("NOMENCLATURA"),result.getDouble("CANTIDAD")));
			}
			st.close();
			return listaActivos;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: selectACTIVOS (clase ActivoDaoJDBC)");
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<String> selectNomenclaturas(int idusuario) {
		Connection coneccion = null;
		List<String> listaNomenclaturas = new ArrayList<String>();
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("SELECT NOMENCLATURA FROM ACTIVOS WHERE IDUSUARIO=" + idusuario + ";");
			ResultSet result = st.executeQuery(sql);
			while (result.next()) {
				listaNomenclaturas.add(result.getString("NOMENCLATURA"));
			}
			st.close();
			return listaNomenclaturas;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: selectNomenclaturas (clase ActivoDaoJDBC)");
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<String> selectNomenclaturasCripto(int idusuario) {
		Connection coneccion = null;
		List<String> listaNomenclaturas = new ArrayList<String>();
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("SELECT A.NOMENCLATURA FROM ACTIVOS A INNER JOIN STOCK S ON A.NOMENCLATURA=S.NOMENCLATURA WHERE A.IDUSUARIO="
					+ idusuario + " AND S.TIPO='CRIPTO';");
			ResultSet result = st.executeQuery(sql);
			while (result.next()) {
				listaNomenclaturas.add(result.getString("NOMENCLATURA"));
			}
			st.close();
			return listaNomenclaturas;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: selectNomenclaturasCripto (clase ActivoDaoJDBC)");
			System.out.println(e.getMessage());
			return null;
		}
	}

	public int updateCantidad(int idusuario, Moneda moneda) {
		Connection coneccion = null;
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("UPDATE ACTIVOS " + "SET CANTIDAD = " + moneda.getCantidad() + " WHERE NOMENCLATURA='"
					+ moneda.getNomenclatura() + "' AND IDUSUARIO = " + idusuario + ";");
			int resultado = st.executeUpdate(sql);
			st.close();
			return resultado;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: updateCantidad (clase ActivoDaoJDBC)");
			System.out.println(e.getMessage());
			return -1;
		}
	}

	public double selectCantidadNomenclatura(Moneda moneda) {
		Connection coneccion = null;
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("SELECT CANTIDAD FROM ACTIVOS WHERE NOMENCLATURA='" + moneda.getNomenclatura() + "';");
			ResultSet result = st.executeQuery(sql);
			double resultado = result.getDouble("CANTIDAD");
			st.close();
			return resultado;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: selectCantidadNomenclatura (clase ActivoDaoJDBC)");
			System.out.println(e.getMessage());
			return -1;
		}
	}

}
