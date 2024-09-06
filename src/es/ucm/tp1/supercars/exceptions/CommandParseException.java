package es.ucm.tp1.supercars.exceptions;

public class CommandParseException extends GameException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6532033814969723624L;

	public CommandParseException () {
		super();
	}
	
    public CommandParseException(String message) {
        super(message);
    }
    
    public CommandParseException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public CommandParseException(Throwable cause) {
        super(cause);
    }
    
    CommandParseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
	
}
