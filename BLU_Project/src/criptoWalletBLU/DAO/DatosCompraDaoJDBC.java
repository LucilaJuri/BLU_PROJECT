package criptoWalletBLU.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import criptoWalletBLU.CLASES.OperacionCompra;
import criptoWalletBLU.SINGLETONS.SingletonConexiones;

public class DatosCompraDaoJDBC implements DatosCompraDao {

	public int crearTablaDatosCompra() {
		Connection coneccion = null;
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("CREATE TABLE IF NOT EXISTS\"DATOSCOMPRA\" (\r\n" + "	\"IDCOMPRA\"	INTEGER UNIQUE,\r\n"
					+ "	\"CRIPTO\"	TEXT NOT NULL,\r\n" + "	\"FIAT\"	TEXT NOT NULL,\r\n"
					+ "	\"CANTCRIPTO\"	REAL NOT NULL,\r\n" + "	\"CANTFIAT\"	REAL NOT NULL,\r\n"
					+ "	\"FECHA\"	TEXT NOT NULL,\r\n" + "	PRIMARY KEY(\"IDCOMPRA\" AUTOINCREMENT)\r\n" + ");");
			int result = st.executeUpdate(sql);
			st.close();
			return result;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: crearTablaDatosCompra (clase DatosCompraDaoJDBC)");
			System.out.println(e.getMessage());
			return -1;
		}
	}

	public int insertDatosCompra(OperacionCompra datosCompra) {
		Connection coneccion = null;
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("INSERT INTO DATOSCOMPRA (CRIPTO, FIAT, CANTCRIPTO, CANTFIAT, FECHA) " + "VALUES ('"
					+ datosCompra.getCripto() + "', '" + datosCompra.getFiat() + "', " + datosCompra.getCantCripto()
					+ ", " + datosCompra.getCantFiat() + ", '" + datosCompra.getFecha() + "');");
			int result = st.executeUpdate(sql);
			st.close();
			return result;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: insertDatosCompra (clase DatosCompraDaoJDBC)");
			System.out.println(e.getMessage());
			return -1;
		}
	}

}
