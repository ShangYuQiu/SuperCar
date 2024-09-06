package es.ucm.tp1.supercars.exceptions;

public class NotEnoughCoinsException extends CommandExcuteException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5122445159614335437L;

	public NotEnoughCoinsException () {
		super();
	}
	
    public NotEnoughCoinsException(String message) {
        super(message);
    }
    
    public NotEnoughCoinsException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public NotEnoughCoinsException(Throwable cause) {
        super(cause);
    }
    
    NotEnoughCoinsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
