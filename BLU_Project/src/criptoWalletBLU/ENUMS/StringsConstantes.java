package criptoWalletBLU.ENUMS;

public enum StringsConstantes {
	Y("Y"), N("N"), CRIPTO("CRIPTO"), FIAT("FIAT"), VALOR("VALOR"), NOMENCLATURA("NOMENCLATURA"), CANTIDAD("CANTIDAD");

	private String str;

	StringsConstantes(String str) {
		this.str = str;
	}

	public String getStr() {
		return str;
	}
}
