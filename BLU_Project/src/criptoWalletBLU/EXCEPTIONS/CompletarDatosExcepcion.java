package criptoWalletBLU.EXCEPTIONS;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class CompletarDatosExcepcion extends ExcepcionPopupError {
	
	private final String cuerpo = "Es obligatorio completar todos los campos solicitados.";
	private final String titulo = "Campos vacíos";
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
