package criptoWalletBLU.COMPARATORS;
import java.util.Comparator;

import criptoWalletBLU.CLASES.Moneda;
public class ComparadorValor implements Comparator<Moneda>{
	public int compare(Moneda m1, Moneda m2) {
		double res = (m1.getPrecio()-m2.getPrecio());
		if (res<0) return -1;
		else if (res>0) return 1;
		else return 0;
	}
}
