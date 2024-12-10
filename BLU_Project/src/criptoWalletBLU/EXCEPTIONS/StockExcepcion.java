package criptoWalletBLU.EXCEPTIONS;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class StockExcepcion extends ExcepcionPopupError {

	private final String cuerpo = "No se dispone del stock suficiente.";
	private final String titulo = "Stock insuficiente";
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
