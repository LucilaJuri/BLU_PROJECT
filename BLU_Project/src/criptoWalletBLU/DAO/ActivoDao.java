package criptoWalletBLU.DAO;

import java.math.BigDecimal;
import java.util.List;

import criptoWalletBLU.CLASES.Moneda;

public interface ActivoDao {
	public int crearTablaActivos();

	public int insertActivo(int idusuario, String nomenclatura, BigDecimal cantidad);

	public List<Moneda> selectActivos(int idusuario);

	public List<String> selectNomenclaturas(int idusuario);

	public int updateCantidad(int idusuario, String nomenclatura, double cantidad);

	public double selectCantidadNomenclatura(String nomenclatura, int idUsuario);

	public List<String> selectNomenclaturasCripto(int idusuario);

	public void borrarActivos(int idUsuario);
}
