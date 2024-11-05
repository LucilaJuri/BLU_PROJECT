package criptoWalletBLU.DAO;

import criptoWalletBLU.CLASES.OperacionSwap;

public interface DatosSwapDao {
	
	public int crearTablaDatosSwap();
	
	public int insertDatosSwap(OperacionSwap datosSwap);

}
