package miw.mwl.BowlingMIWException;

public class WrongNumPlayersException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @uml.property  name="numPlayers"
	 */
	private int numPlayers; 
	public WrongNumPlayersException() {
		// TODO Auto-generated constructor stub
	}

	public WrongNumPlayersException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public WrongNumPlayersException(int numPlayers) {
		super();
		this.numPlayers = numPlayers;
	}

	public WrongNumPlayersException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public WrongNumPlayersException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public WrongNumPlayersException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		String message;
		if (numPlayers < 1 ) {
			message = "El número de jugadores no puede ser menor que 1";
		} else {
			message = "El número de jugadores es mayor que el permitido";
		}
		return message;
	}
}
