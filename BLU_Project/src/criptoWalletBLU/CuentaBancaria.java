/** @author Juri, Lucila
 *  @author Cladera,  Blas Martin
 */

package criptoWalletBLU;

public class CuentaBancaria {
	private Persona titular; /** @see Persona */
	private int cvu;
	
	public CuentaBancaria(Persona titular, int cvu) {
		this.titular = titular;
		this.cvu = cvu;
	}

	public Persona getTitular() {
		return titular;
	}

	public void setTitular(Persona titular) {
		this.titular = titular;
	}

	public int getCvu() {
		return cvu;
	}

	public void setCvu(int cvu) {
		this.cvu = cvu;
	}
	
	
}
