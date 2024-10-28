package criptoWalletBLU.DAO;

public class FACTORYDAO {
	public static STOCKDAO getSTOCKDAO() {
		return new STOCKDAOJDBC();
	}
	
	public static ACTIVODAO getACTIVODAO() {
		return new ACTIVODAOJDBC();
	}
	
	public static DATOSCOMPRADAO getDATOSCOMPRADAO() {
		return new DATOSCOMPRADAOJDBC();
	}
}
