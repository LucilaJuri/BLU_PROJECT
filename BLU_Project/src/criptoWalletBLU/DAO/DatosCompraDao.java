package criptoWalletBLU.DAO;

import criptoWalletBLU.CLASES.OperacionCompra;

public interface DatosCompraDao {
	
	public int crearTablaDatosCompra();
	
	public int insertDatosCompra(OperacionCompra datosCompra);
}
