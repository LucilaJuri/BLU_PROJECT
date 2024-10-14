package criptoWalletBLU;
import java.util.Comparator;
public class ComparadorNomenclatura implements Comparator<Moneda>{
	public int compare(Moneda m1, Moneda m2) {
		return m1.getNomenclatura().compareTo(m2.getNomenclatura());
	}
}