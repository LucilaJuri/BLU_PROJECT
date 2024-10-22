/** @author Juri, Lucila
 *  @author Cladera,  Blas Martin
 */

package criptoWalletBLU.CLASES;

public class Moneda {
	private double precio;
	private double cantidad;
	private String nombre;
	private String nomenclatura;
	private double volatilidad;
	
	/** 
	 * @param precio; Este dato nos lo brindará la ApiCriptomonedas con el precio actual de la criptomoneda.
	 */
	
	public Moneda(double precio, double cantidad, String nombre, String nomenclatura, double volatilidad) {
		this.precio = precio;
		this.cantidad = cantidad;
		this.nombre = nombre;
		this.nomenclatura = nomenclatura;
		this.volatilidad = volatilidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "Moneda [precio=" + precio + ", cantidad=" + cantidad + ", nombre=" + nombre + ", nomenclatura="
				+ nomenclatura + ", volatilidad=" + volatilidad + "]";
	}

	public double getVolatilidad() {
		return volatilidad;
	}

	public void setVolatilidad(double volatilidad) {
		this.volatilidad = volatilidad;
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
