package criptoWalletBLU.PRUEBAS;

import criptoWalletBLU.CLASES.Persona;
import criptoWalletBLU.DAO.*;

public class PREUBAMAINPAERSONAs {

	public static void main(String[] args) {
		PersonasDao dao = new PersonasDaoJDBC();
		Persona persona = new Persona("Lucila","Juri",null,0,null);
		System.out.println(dao.insertPersona(persona));

	}

}
