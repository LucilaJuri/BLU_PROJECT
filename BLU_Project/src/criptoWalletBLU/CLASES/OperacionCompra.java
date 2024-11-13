package criptoWalletBLU.CLASES;

public class OperacionCompra {
	private String cripto;
	private String fiat;
	private double cantCripto;
	private double cantFiat;
	private String fecha;

	public String getCripto() {
		return cripto;
	}

	public void setCripto(String cripto) {
		this.cripto = cripto;
	}

	public String getFiat() {
		return fiat;
	}

	public void setFiat(String fiat) {
		this.fiat = fiat;
	}

	public double getCantCripto() {
		return cantCripto;
	}

	public void setCantCripto(double cantCripto) {
		this.cantCripto = cantCripto;
	}

	public double getCantFiat() {
		return cantFiat;
	}

	public void setCantFiat(double cantFiat) {
		this.cantFiat = cantFiat;
	}

	public OperacionCompra(String cripto, String fiat, double cantCripto, double cantFiat, String fecha) {
		this.cripto = cripto;
		this.fiat = fiat;
		this.cantCripto = cantCripto;
		this.cantFiat = cantFiat;
		this.fecha = fecha;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
