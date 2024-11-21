package criptoWalletBLU.DAO;

import java.util.List;

import criptoWalletBLU.CLASES.Moneda;

public interface StockDao {

	public int crearTablaStock();

	public int insertStock(Moneda moneda, String tipo);

	public List<Moneda> selectStock();

	public int contarStock();

	public int updateCantidad(Moneda moneda);

	public List<String> selectNomenclaturas();

	public List<String> selectNomenclaturasCripto();

	public List<String> selectNomenclaturasFiat();

	public double selectPrecioNomenclatura(Moneda moneda);

	public double selectCantidadNomenclatura(Moneda moneda);

	public List<Moneda> selectStockCripto();
	
	public List<Moneda> selectMonedasUsuario(int idUsuario);
	
	public int updatePrecio(String nomenclatura, double precio);
}