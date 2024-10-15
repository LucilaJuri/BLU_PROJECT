package criptoWalletBLU.DAO;

import java.sql.ResultSet;

public interface STOCKDAO {
	public int insertSTOCK(String nomenclatura, double dolar, double stock, String nombre, String tipo);
	
	public ResultSet selectSTOCK();
	
	public int contarSTOCK();
	
	public int updateCantidad(int i, double cantidad);
}