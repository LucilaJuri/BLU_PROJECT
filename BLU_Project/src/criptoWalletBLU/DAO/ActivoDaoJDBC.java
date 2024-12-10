package criptoWalletBLU.DAO;

import java.math.BigDecimal;
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
					+ "	\"NOMENCLATURA\"	TEXT NOT NULL,\r\n"
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

	public int insertActivo(int idusuario, String nomenclatura, BigDecimal cantidad) {
		Connection coneccion = null;
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("INSERT INTO ACTIVOS (IDUSUARIO, CANTIDAD, NOMENCLATURA)" + "VALUES (" + idusuario + ", "
					+ cantidad + ", " + "'" + nomenclatura + "');");
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

	public int updateCantidad(int idusuario, String nomenclatura, double cantidad) {
		Connection coneccion = null;
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("UPDATE ACTIVOS " + "SET CANTIDAD = " + cantidad + " WHERE NOMENCLATURA='"
					+ nomenclatura + "' AND IDUSUARIO = " + idusuario + ";");
			int resultado = st.executeUpdate(sql);
			st.close();
			return resultado;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: updateCantidad (clase ActivoDaoJDBC)");
			System.out.println(e.getMessage());
			return -1;
		}
	}

	public double selectCantidadNomenclatura(String nomenclatura, int idUsuario) {
		Connection coneccion = null;
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("SELECT CANTIDAD FROM ACTIVOS WHERE NOMENCLATURA='" + nomenclatura + "' AND IDUSUARIO="+idUsuario+";");
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
	
	public void borrarActivos(int idUsuario) {
		Connection coneccion = null;
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("DELETE FROM ACTIVOS WHERE IDUSUARIO="+idUsuario+";");
			st.executeUpdate(sql);
			st.close();
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: borrarActivos (clase ActivoDaoJDBC)");
			System.out.println(e.getMessage());
		}
	}

}
