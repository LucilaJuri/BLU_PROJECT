package criptoWalletBLU.CLASES;

public class OperacionSwap {
	private int idUsuario;
	private String criptoOrigen;
	private String criptoDestino;
	private double cantCriptoOrigen;
	private double cantCriptoDestino;
	private String fecha;

	public String getCriptoOrigen() {
		return criptoOrigen;
	}

	public void setCriptoOrigen(String criptoOrigen) {
		this.criptoOrigen = criptoOrigen;
	}

	public String getCriptoDestino() {
		return criptoDestino;
	}

	public void setCriptoDestino(String criptoDestino) {
		this.criptoDestino = criptoDestino;
	}

	public double getCantCriptoOrigen() {
		return cantCriptoOrigen;
	}

	public void setCantCriptoOrigen(double cantCriptoOrigen) {
		this.cantCriptoOrigen = cantCriptoOrigen;
	}

	public double getCantCriptoDestino() {
		return cantCriptoDestino;
	}

	public void setCantCriptoDestino(double cantCriptoDestino) {
		this.cantCriptoDestino = cantCriptoDestino;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public OperacionSwap(int idUsuario, String criptoOrigen, String criptoDestino, double cantCriptoOrigen, double cantCriptoDestino,
			String fecha) {
		this.idUsuario=idUsuario;
		this.criptoOrigen = criptoOrigen;
		this.criptoDestino = criptoDestino;
		this.cantCriptoOrigen = cantCriptoOrigen;
		this.cantCriptoDestino = cantCriptoDestino;
		this.fecha = fecha;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

}
