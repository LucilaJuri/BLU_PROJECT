package criptoWalletBLU.DAO;

import java.util.List;

import criptoWalletBLU.CLASES.OperacionCompra;

public interface DatosCompraDao {

	public int crearTablaDatosCompra();

	public int insertDatosCompra(OperacionCompra datosCompra);
	
	public List<OperacionCompra> selectDatosCompra(int idUsuario);
}
