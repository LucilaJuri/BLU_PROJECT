/** @author Juri, Lucila
 *  @author Cladera,  Blas Martin
 */

package criptoWalletBLU;

public abstract class Moneda {
	private double precio;
	private double cantidad;
	private String nombre;
	private String nomenclatura;
	
	/** 
	 * @param precio; Este dato nos lo brindará la ApiCriptomonedas con el precio actual de la criptomoneda.
	 */
	
	public Moneda(double precio, double cantidad, String nombre, String nomenclatura) {
		this.precio = precio;
		this.cantidad = cantidad;
		this.nombre = nombre;
		this.nomenclatura = nomenclatura;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNomenclatura() {
		return nomenclatura;
	}

	public void setNomenclatura(String nomenclatura) {
		this.nomenclatura = nomenclatura;
	}
}
