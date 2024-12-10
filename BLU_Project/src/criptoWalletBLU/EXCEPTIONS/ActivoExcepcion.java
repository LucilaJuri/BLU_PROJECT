package criptoWalletBLU.EXCEPTIONS;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class ActivoExcepcion extends ExcepcionPopupError {

	private final String cuerpo = "No se dispone del activo suficiente.";
	private final String titulo = "Activo insuficiente";
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
