package criptoWalletBLU.DAO;

import java.sql.ResultSet;
import java.util.List;

public interface STOCKDAO {
	public int insertSTOCK(String nomenclatura, double dolar, double stock, String nombre, String tipo);
	
	public ResultSet selectSTOCK();
	
	public int contarSTOCK();
	
	public int updateCantidad(String nomenclatura, double cantidad);
	
	public ResultSet selectNomenclaturas();
	
	public List<String> selectNomenclaturasCripto();
	
	public List<String> selectNomenclaturasFiat();
	
	public double selectPrecioNomenclatura(String nomenclatura);
	
	public double selectCantidadNomenclatura(String nomenclatura);
}