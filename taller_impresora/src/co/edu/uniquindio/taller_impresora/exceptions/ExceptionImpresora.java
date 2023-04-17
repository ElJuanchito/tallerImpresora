package co.edu.uniquindio.taller_impresora.exceptions;

public class ExceptionImpresora extends Exception{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Genera una <b>exception</b> relacionada al funcionamiento de la impresora
	 * @param message
	 */
	public ExceptionImpresora(String message) {
		super(message);
	}
}
