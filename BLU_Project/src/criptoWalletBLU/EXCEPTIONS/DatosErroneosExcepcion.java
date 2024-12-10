package criptoWalletBLU.EXCEPTIONS;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class DatosErroneosExcepcion extends ExcepcionPopupError {

	private final String cuerpo = "No existe ningún usuario registrado con los datos ingresados.";
	private final String titulo = "Datos erróneos";
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
