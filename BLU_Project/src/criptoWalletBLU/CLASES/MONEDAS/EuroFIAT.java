/** @author Juri, Lucila
 *  @author Cladera,  Blas Martin
 */

package criptoWalletBLU.CLASES.MONEDAS;

import criptoWalletBLU.CLASES.Moneda;

public class EuroFIAT extends Moneda {

	public EuroFIAT(double precio, double cantidad, String nombre, String nomenclatura, double volatilidad) {
		super(precio, cantidad, nombre, nomenclatura, volatilidad);
	}

}