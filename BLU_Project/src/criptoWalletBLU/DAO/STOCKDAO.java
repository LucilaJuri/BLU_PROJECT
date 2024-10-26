package criptoWalletBLU.DAO;

import java.sql.ResultSet;

public interface STOCKDAO {
	public int insertSTOCK(String nomenclatura, double dolar, double stock, String nombre, String tipo);
	
	public ResultSet selectSTOCK();
	
	public int contarSTOCK();
	
	public int updateCantidad(String nomenclatura, double cantidad);
	
	public ResultSet selectNomenclaturas();
	
	public ResultSet selectNomenclaturasCripto();
	
	public ResultSet selectNomenclaturasFiat();
	
	public ResultSet selectPrecioNomenclatura(String nomenclatura);
	
	public ResultSet selectCantidadNomenclatura(String nomenclatura);
}