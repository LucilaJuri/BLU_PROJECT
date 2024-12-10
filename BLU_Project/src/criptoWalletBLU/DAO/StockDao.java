package criptoWalletBLU.DAO;

import java.math.BigDecimal;
import java.util.List;

import criptoWalletBLU.CLASES.Moneda;

public interface StockDao {

	public int crearTablaStock();

	public int insertStock(Moneda moneda, String tipo);

	public List<Moneda> selectStock();

	public int contarStock();

	public int updateCantidad(String nomenclatura, BigDecimal cantidad);

	public List<String> selectNomenclaturas();

	public List<String> selectNomenclaturasCripto();

	public List<String> selectNomenclaturasFiat();

	public double selectPrecioNomenclatura(String nomenclatura);

	public double selectCantidadNomenclatura(String nomenclaturaCripto);

	public List<Moneda> selectStockCripto();
	
	public List<Moneda> selectMonedasUsuario(int idUsuario);
	
	public int updatePrecio(String nomenclatura, double precio);
	
	public List<Moneda> selectNomenclaturaCantidadUsuario(int idUsuario);
}