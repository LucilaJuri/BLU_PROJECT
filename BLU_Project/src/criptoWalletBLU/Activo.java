/** @author Juri, Lucila
 *  @author Cladera,  Blas Martin
 */

package criptoWalletBLU;

public class Activo {
	private String direccion; 
	private Moneda moneda;		/** @see Moneda */
	
	public Activo(String direccion, Moneda moneda) {
		this.direccion = direccion;
		this.moneda = moneda;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}
	
}
