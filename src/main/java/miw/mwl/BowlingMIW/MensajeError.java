package miw.mwl.BowlingMIW;

public class MensajeError extends Mensaje{

	public MensajeError(String texto) {
		super("Error: " + texto, Mensaje.CODIGO_ERROR);
	}

}
