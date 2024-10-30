package criptoWalletBLU.DAO;

import java.util.List;

import criptoWalletBLU.CLASES.Moneda;

public interface ActivoDao {
	public int insertACTIVO(int idusuario, Moneda moneda);
	
	public List<Moneda> selectACTIVOS(int idusuario);
	
	public List<String> selectNomenclaturas(int idusuario);
	
	public int updateCantidad(int idusuario, Moneda moneda);
	
	public double selectCantidadNomenclatura(Moneda moneda);
	
	public List<String> selectNomenclaturasCripto(int idusuario);
}
