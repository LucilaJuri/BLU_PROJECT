package criptoWalletBLU.DAO;

import java.util.List;

import criptoWalletBLU.CLASES.Moneda;

public interface STOCKDAO {
	public int insertSTOCK(Moneda moneda, String tipo);
	
	public List<Moneda> selectSTOCK();
	
	public int contarSTOCK();
	
	public int updateCantidad(Moneda moneda);
	
	public List<String> selectNomenclaturas();
	
	public List<String> selectNomenclaturasCripto();
	
	public List<String> selectNomenclaturasFiat();
	
	public double selectPrecioNomenclatura(Moneda moneda);
	
	public double selectCantidadNomenclatura(Moneda moneda);
	
	public List<Moneda> selectSTOCKCripto();
}