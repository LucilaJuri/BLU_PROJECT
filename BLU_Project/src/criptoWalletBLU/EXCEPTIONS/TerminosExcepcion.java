package criptoWalletBLU.EXCEPTIONS;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class TerminosExcepcion extends ExcepcionPopupError {
	
	private final String cuerpo = "Debes aceptar nuestros Términos y Condiciones de uso para poder registrarte.";
	private final String titulo = "Términos y Condiciones de uso";
	private final int icono = JOptionPane.ERROR_MESSAGE;
	
	public String getCuerpo() {
		return cuerpo;
	}
	public String getTitulo() {
		return titulo;
	}
	public int getIcono() {
		return icono;
	}
	
	
}
