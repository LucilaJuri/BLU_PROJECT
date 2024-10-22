package criptoWalletBLU.DAO;

import java.sql.ResultSet;

public interface ACTIVODAO {
	public int instertACTIVO(int idusuario, double cantidad, String nomenclatura);
	
	public ResultSet selectACTIVOS(int idusuario);
}
