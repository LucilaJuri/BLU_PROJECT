package criptoWalletBLU.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import criptoWalletBLU.CLASES.OperacionCompra;
import criptoWalletBLU.SINGLETONS.SingletonConexiones;

public class DatosCompraDaoJDBC implements DatosCompraDao {

	public int crearTablaDatosCompra() {
		Connection coneccion = null;
		try {
			coneccion = SingletonConexiones.getConexion();
			Statement st = coneccion.createStatement();
			String sql = ("CREATE TABLE IF NOT EXISTS \"DATOSCOMPRA\" (\r\n"
					+ "	\"IDCOMPRA\"	INTEGER UNIQUE,\r\n"
					+ "	\"CRIPTO\"	TEXT NOT NULL,\r\n"
					+ "	\"FIAT\"	TEXT NOT NULL,\r\n"
					+ "	\"CANTCRIPTO\"	REAL NOT NULL,\r\n"
					+ "	\"CANTFIAT\"	REAL NOT NULL,\r\n"
					+ "	\"FECHA\"	TEXT NOT NULL,\r\n"
					+ "	\"IDUSUARIO\"	INTEGER NOT NULL,\r\n"
					+ "	PRIMARY KEY(\"IDCOMPRA\" AUTOINCREMENT)\r\n"
					+ ");");
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
			String sql = ("INSERT INTO DATOSCOMPRA (IDUSUARIO, CRIPTO, FIAT, CANTCRIPTO, CANTFIAT, FECHA) " + "VALUES ("+datosCompra.getIdUsuario()+", '"
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
	
public List<OperacionCompra> selectDatosCompra(int idUsuario){
	Connection coneccion = null;
	List<OperacionCompra> listaTransacciones = new ArrayList<OperacionCompra>();
	try {
		coneccion = SingletonConexiones.getConexion();
		Statement st = coneccion.createStatement();
		String sql = ("SELECT * FROM DATOSCOMPRA WHERE IDUSUARIO=" + idUsuario + ";");
		ResultSet result = st.executeQuery(sql);
		while (result.next()) {
			listaTransacciones.add(new OperacionCompra(idUsuario,result.getString("CRIPTO"),result.getString("FIAT"),result.getDouble("CANTCRIPTO"),result.getDouble("CANTFIAT"),result.getString("FECHA")));
		}
		st.close();
		return listaTransacciones;
	} catch (SQLException e) {
		System.out.println("ERROR EN METODO: selectACTIVOS (clase ActivoDaoJDBC)");
		System.out.println(e.getMessage());
		return null;
	}
}

}
