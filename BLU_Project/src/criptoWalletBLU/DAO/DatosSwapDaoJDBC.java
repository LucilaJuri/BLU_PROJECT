package criptoWalletBLU.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import criptoWalletBLU.CLASES.OperacionSwap;
import criptoWalletBLU.SINGLETONS.SingletonConexiones;

public class DatosSwapDaoJDBC implements DatosSwapDao {

	public int crearTablaDatosSwap() {
		Connection coneccion = null;
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("CREATE TABLE IF NOT EXISTS \"DATOSSWAP\" (\r\n"
					+ "	\"IDSWAP\"	INTEGER,\r\n"
					+ "	\"CRIPTOORG\"	TEXT NOT NULL,\r\n"
					+ "	\"CRIPTODEST\"	TEXT NOT NULL,\r\n"
					+ "	\"CANTCRIPTOORG\"	REAL NOT NULL,\r\n"
					+ "	\"CANTCRIPTODEST\"	REAL NOT NULL,\r\n"
					+ "	\"FECHA\"	TEXT NOT NULL,\r\n"
					+ "	\"IDUSUARIO\"	INTEGER NOT NULL,\r\n"
					+ "	PRIMARY KEY(\"IDSWAP\" AUTOINCREMENT)\r\n"
					+ ");");
			int result = st.executeUpdate(sql);
			st.close();
			return result;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: crearTablaDatosSwap (clase crearTablaDatosSwap)");
			System.out.println(e.getMessage());
			return -1;
		}
	}

	public int insertDatosSwap(OperacionSwap datosSwap) {
		Connection coneccion = null;
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("INSERT INTO DATOSSWAP (IDUSUARIO, CRIPTOORG, CRIPTODEST, CANTCRIPTOORG, CANTCRIPTODEST, FECHA) "
					+ "VALUES ("+datosSwap.getIdUsuario()+", ' ('" + datosSwap.getCriptoOrigen() + "', '" + datosSwap.getCriptoDestino() + "', "
					+ datosSwap.getCantCriptoOrigen() + ", " + datosSwap.getCantCriptoDestino() + ", '"
					+ datosSwap.getFecha() + "');");
			int result = st.executeUpdate(sql);
			st.close();
			return result;
		} catch (SQLException e) {
			System.out.println("ERROR EN METODO: insertDatosSwap (clase DatosSwapDaoJDBC)");
			System.out.println(e.getMessage());
			return -1;
		}
	}

}
