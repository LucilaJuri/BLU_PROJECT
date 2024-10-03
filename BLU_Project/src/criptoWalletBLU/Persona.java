/** @author Juri, Lucila
 *  @author Cladera,  Blas Martin
 */

package criptoWalletBLU;

public class Persona {
	private String nombre;
	private String apellido;
	private String pais;
	private int dni;
	private Fecha fechaNacimiento;	/** @see Fecha */
	
	
	public Persona(String nombre, String apellido, String pais, int dni, Fecha fechaNacimiento) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.pais = pais;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public Fecha getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento (Fecha fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
}
