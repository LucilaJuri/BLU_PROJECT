package criptoWalletBLU.DAO;

import java.util.List;

import criptoWalletBLU.CLASES.Persona;

public interface PersonasDao {
	
	public int insertPersona(Persona persona);
	
	public List<Persona> selectPersonas();
	
	public Persona selectPersona(int idPersona);
	
	public int crearTablaPersonas();
}
