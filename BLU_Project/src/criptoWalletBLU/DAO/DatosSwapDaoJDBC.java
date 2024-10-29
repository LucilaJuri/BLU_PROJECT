package criptoWalletBLU.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import criptoWalletBLU.CLASES.OperacionSwap;

public class DatosSwapDaoJDBC implements DatosSwapDao{
	public int insertDATOSSWAP(OperacionSwap datosSwap) {
		Connection coneccion = null;
		try {
			coneccion=DriverManager.getConnection("jdbc:sqlite:BLUDATABASE.db");
			Statement st = coneccion.createStatement();
			String sql = (
				    "INSERT INTO DATOSSWAP (CRIPTOORG, CRIPTODEST, CANTCRIPTOORG, CANTCRIPTODEST, FECHA) " +
				    "VALUES ('" + datosSwap.getCriptoOrigen() + "', '" +
				    datosSwap.getCriptoDestino() + "', " +
				    datosSwap.getCantCriptoOrigen() + ", " +
				    datosSwap.getCantCriptoDestino() + ", '"+
				    datosSwap.getFecha()+"');"
				);
			int result = st.executeUpdate(sql);
			coneccion.close();
			st.close();
			return result;
		}
		catch(SQLException e) {
			System.out.println("ERROR EN METODO: insertDATOSSWAP (clase DatosSwapDaoJDBC)");
			System.out.println(e.getMessage());
			return -1;
		}
	}

}
