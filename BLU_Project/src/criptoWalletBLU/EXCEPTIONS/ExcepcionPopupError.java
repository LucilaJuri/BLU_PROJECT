package criptoWalletBLU.EXCEPTIONS;

@SuppressWarnings("serial")
public abstract class ExcepcionPopupError extends Exception {

	public abstract String getCuerpo();
	
	public abstract String getTitulo();
	
	public abstract int getIcono();
}
