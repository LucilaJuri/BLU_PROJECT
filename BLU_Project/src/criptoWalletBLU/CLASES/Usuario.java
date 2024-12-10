/** @author Juri, Lucila
 *  @author Cladera,  Blas Martin
 */

package criptoWalletBLU.CLASES;

import java.util.List;

import criptoWalletBLU.CLASES.MONEDAS.*;


public class Usuario {
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public CuentaBancaria getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	public List<Preguntas> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Preguntas> preguntas) {
		this.preguntas = preguntas;
	}

	public Activo[] getActivos() {
		return activos;
	}

	public void setActivos(Activo[] activos) {
		this.activos = activos;
	}

	public List<Defi> getDefis() {
		return defis;
	}

	public void setDefis(List<Defi> defis) {
		this.defis = defis;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMonedaFiad() {
		return monedaFiad;
	}

	public void setMonedaFiad(String monedaFiad) {
		this.monedaFiad = monedaFiad;
	}

	public boolean isTieneDocumentos() {
		return tieneDocumentos;
	}

	public void setTieneDocumentos(boolean tieneDocumentos) {
		this.tieneDocumentos = tieneDocumentos;
	}

	public boolean isActivoNotificaciones() {
		return activoNotificaciones;
	}

	public void setActivoNotificaciones(boolean activoNotificaciones) {
		this.activoNotificaciones = activoNotificaciones;
	}

	public boolean isEstaActivo() {
		return estaActivo;
	}

	public void setEstaActivo(boolean estaActivo) {
		this.estaActivo = estaActivo;
	}

	public double getSaldoTotal() {
		return saldoTotal;
	}

	public void setSaldoTotal(double saldoTotal) {
		this.saldoTotal = saldoTotal;
	}

	public int getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public void setNumeroTelefonico(int numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}
	
	public Usuario() {
	}
	
	public boolean estaVacio() {
		return (mail==null);//Usamos cualquier campo para ver si fue creado o no
	}

	public Usuario(int idUsuario, int idPersona, CuentaBancaria cuentaBancaria, List<Preguntas> preguntas,
			Activo[] activos, List<Defi> defis, String contrasenia, String mail, String monedaFiad,
			boolean tieneDocumentos, boolean activoNotificaciones, boolean estaActivo, double saldoTotal,
			int numeroTelefonico) {
		super();
		this.idUsuario = idUsuario;
		this.idPersona = idPersona;
		this.cuentaBancaria = cuentaBancaria;
		this.preguntas = preguntas;
		this.activos = activos;
		this.defis = defis;
		this.contrasenia = contrasenia;
		this.mail = mail;
		this.monedaFiad = monedaFiad;
		this.tieneDocumentos = tieneDocumentos;
		this.activoNotificaciones = activoNotificaciones;
		this.estaActivo = estaActivo;
		this.saldoTotal = saldoTotal;
		this.numeroTelefonico = numeroTelefonico;
		crearActivos(this.activos);
	}
	
	public Usuario(int idPersona, String mail, String contrasena) {
		this.idPersona=idPersona;
		this.mail=mail;
		this.contrasenia=contrasena;
	}
	
	public Usuario(int idUsuario,int idPersona, String mail, String contrasena) {
		this.idUsuario=idUsuario;
		this.idPersona=idPersona;
		this.mail=mail;
		this.contrasenia=contrasena;
	}

	private int idUsuario;
	private int idPersona;
	/** @see Persona */
	private CuentaBancaria cuentaBancaria;
	/** @see CuentaBancaria */
	private List<Preguntas> preguntas;
	/** @see Preguntas */
	private Activo[] activos;
	/** @see Activo */
	private List<Defi> defis;
	/** @see Defi */
	private String contrasenia;
	private String mail;
	private String monedaFiad;
	private boolean tieneDocumentos;
	private boolean activoNotificaciones;
	private boolean estaActivo;
	private double saldoTotal;
	private int numeroTelefonico;

	/**
	 * private Fotos documentacion; por ahora no sabemos como vamos a manejar las
	 * imagenes de la documentacion private List Operacion operaciones; será el
	 * historial de operaciones del usuario
	 */
	

	/**
	 * Para cada activo del usuario se le asignará una dirección aleatoria única
	 * para recibir transferencias, por ahora dejamos un String genérico. El precio
	 * de cada activo respecto de la moneda fiduciara de referencia elegida por el
	 * usuario será consultado a una API, por ahora lo dejamos en 1.
	 */
	private void crearActivos(Activo[] activos) {
		activos = new Activo[10];
		activos[0] = new Activo("direccion aleatoria", new DogecoinCripto(1, 0, "DogecoinCripto", "DOGE", 0));
		activos[1] = new Activo("direccion aleatoria", new USDCCripto(1, 0, "USDCCripto", "USDC", 0));
		activos[2] = new Activo("direccion aleatoria", new BitcoinCripto(1, 0, "BitcoinCripto", "BTC", 0));
		activos[3] = new Activo("direccion aleatoria", new USDTCripto(1, 0, "USDTCripto", "USDT", 0));
		activos[4] = new Activo("direccion aleatoria", new EthereumCripto(1, 0, "EthereumCripto0", "ETH", 0));
		activos[5] = new Activo("direccion aleatoria",
				new DolarZimbabuenseFIAT(1, 0, "DolarZimbabuenseFIAT", "ZWD", 0));
		activos[6] = new Activo("direccion aleatoria", new PesoArgFIAT(1, 0, "PesoArgFIAT", "ARG", 0));
		activos[7] = new Activo("direccion aleatoria", new USDFIAT(1, 0, "USDFIAT", "USD", 0));
		activos[8] = new Activo("direccion aleatoria", new EuroFIAT(1, 0, "EuroFIAT", "EUR", 0));
		activos[9] = new Activo("direccion aleatoria", new LibraFIAT(1, 0, "LibraFIAT", "GBP", 0));
	}
}

