/** @author Juri, Lucila
 *  @author Cladera,  Blas Martin
 */

package criptoWalletBLU.CLASES;

public class Protocolo {
	private String nombreProtocolo;
	private String tipoCripto;
	private double intereses;
	private double comision;
	private Fecha fechaFin;

	/** @see Fecha */
	/** si es null el protocolo no tiene fecha limite */

	public Protocolo(String nombreProtocolo, String tipoCripto, double intereses, double comision, Fecha fechaFin) {
		this.nombreProtocolo = nombreProtocolo;
		this.tipoCripto = tipoCripto;
		this.intereses = intereses;
		this.comision = comision;
		this.fechaFin = fechaFin;
	}

	public String getNombreProtocolo() {
		return nombreProtocolo;
	}

	public void setNombreProtocolo(String nombreProtocolo) {
		this.nombreProtocolo = nombreProtocolo;
	}

	public String getTipoCripto() {
		return tipoCripto;
	}

	public void setTipoCripto(String tipoCripto) {
		this.tipoCripto = tipoCripto;
	}

	public double getIntereses() {
		return intereses;
	}

	public void setIntereses(double intereses) {
		this.intereses = intereses;
	}

	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}

	public Fecha getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Fecha fechaFin) {
		this.fechaFin = fechaFin;
	}

}
