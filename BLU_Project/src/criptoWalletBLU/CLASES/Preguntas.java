/** @author Juri, Lucila
 *  @author Cladera,  Blas Martin
 */

package criptoWalletBLU.CLASES;

public class Preguntas {
	private String pregunta;
	private String respuesta;

	public Preguntas(String pregunta, String respuesta) {
		this.pregunta = pregunta;
		this.respuesta = respuesta;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
}
