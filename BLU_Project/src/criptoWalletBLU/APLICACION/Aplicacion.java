package criptoWalletBLU.APLICACION;

public class Aplicacion {
	public static void main (String [] args) {
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		@SuppressWarnings("unused")
		Controlador controlador = new Controlador(vista,modelo);
    }
}
