package criptoWalletBLU.EXCEPTIONS;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class MailExcepcion extends ExcepcionPopupError {
	
	private String cuerpo;
	private final String titulo = "Términos y Condiciones de uso";
	private String mail;
	private final int icono = JOptionPane.ERROR_MESSAGE;
	
	public MailExcepcion (String mail) {
		this.mail = mail;
		this.cuerpo=("La direccion de E-Mail: "+this.mail+" se encuentra en uso.");
	}

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
