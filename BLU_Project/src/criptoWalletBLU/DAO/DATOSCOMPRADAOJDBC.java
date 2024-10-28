package criptoWalletBLU.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import criptoWalletBLU.CLASES.OperacionCompra;

public class DATOSCOMPRADAOJDBC implements DATOSCOMPRADAO {

	public int insertDATOSCOMPRA(OperacionCompra datosCompra) {
		Connection coneccion = null;
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = (
				    "INSERT INTO DATOSCOMPRA (CRIPTO, FIAT, CANTCRIPTO, CANTFIAT, FECHA) " +
				    "VALUES ('" + datosCompra.getCripto() + "', '" +
				    datosCompra.getFiat() + "', " +
				    datosCompra.getCantCripto() + ", " +
				    datosCompra.getCantFiat() + ", '"+
				    datosCompra.getFecha()+"');"
				);
			int result = st.executeUpdate(sql);
			System.out.println("INSERT exitoso.");
			coneccion.close();
			st.close();
			return result;
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}

}
