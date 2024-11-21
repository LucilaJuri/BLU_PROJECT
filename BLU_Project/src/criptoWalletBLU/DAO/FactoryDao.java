package criptoWalletBLU.DAO;

public class FactoryDao {
	public static StockDao getStockDao() {
		return new StockDaoJDBC();
	}

	public static ActivoDao getActivoDao() {
		return new ActivoDaoJDBC();
	}

	public static DatosCompraDao getDatosCompraDao() {
		return new DatosCompraDaoJDBC();
	}

	public static DatosSwapDao getDatosSwapDao() {
		return new DatosSwapDaoJDBC();
	}
	
	public static UsuariosDao getUsuariosDao() {
		return new UsuariosDaoJDBC();
	}
	
	public static PersonasDao getPersonasDao() {
		return new PersonasDaoJDBC();
	}
}
