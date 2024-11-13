package criptoWalletBLU.COMPARATORS;

import java.util.Comparator;

import criptoWalletBLU.CLASES.Moneda;

public class ComparadorCantidad implements Comparator<Moneda> {
	public int compare(Moneda m1, Moneda m2) {
		double res = (m1.getCantidad() - m2.getCantidad());
		if (res < 0)
			return 1;
		else if (res > 0)
			return -1;
		else
			return 0;
	}
}
