/** @author Juri, Lucila
 *  @author Cladera,  Blas Martin
 */

package criptoWalletBLU.CLASES;

public class Defi {
	private Moneda moneda;			/** @see Moneda */
	private Fecha fechaInicio;		/** @see Fecha */
	private Protocolo protocolo;	/** @see Protocolo */
	
	public Defi(Moneda moneda, Fecha fechaInicio, Protocolo protocolo) {
		this.moneda = moneda;
		this.fechaInicio = fechaInicio;
		this.protocolo = protocolo;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public Fecha getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Fecha fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Protocolo getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(Protocolo protocolo) {
		this.protocolo = protocolo;
	}
	
	
}
