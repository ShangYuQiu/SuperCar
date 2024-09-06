package es.ucm.tp1.supercars.exceptions;

public class NumberFormatException extends CommandParseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4408585209135196038L;

	public NumberFormatException () {
		super();
	}
	
    public NumberFormatException(String message) {
        super(message);
    }
    
    public NumberFormatException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public NumberFormatException(Throwable cause) {
        super(cause);
    }
    
    NumberFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
