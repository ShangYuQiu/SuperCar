package es.ucm.tp1.supercars.exceptions;

public class InvalidPositionException extends CommandExcuteException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8160687883754032293L;

	public InvalidPositionException () {
		super();
	}
	
    public InvalidPositionException(String message) {
        super(message);
    }
    
    public InvalidPositionException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public InvalidPositionException(Throwable cause) {
        super(cause);
    }
    
    InvalidPositionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
