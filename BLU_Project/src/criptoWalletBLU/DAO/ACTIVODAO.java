package criptoWalletBLU.DAO;

import java.sql.ResultSet;
import java.util.List;

import criptoWalletBLU.CLASES.Moneda;

public interface ACTIVODAO {
	public int insertACTIVO(int idusuario, double cantidad, String nomenclatura);
	
	public List<Moneda> selectACTIVOS(int idusuario);
	
	public ResultSet selectNomenclaturas(int idusuario);
	
	public int updateCantidad(String nomenclatura, double cantidad, int idusuario);
	
	public double selectCantidadNomenclatura(String nomenclatura);
}
