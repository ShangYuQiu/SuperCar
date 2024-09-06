package es.ucm.tp1.supercars.exceptions;

public class CommandExcuteException extends GameException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3572145089885528730L;

	
	
	public CommandExcuteException () {
		super();
	}
	
    public CommandExcuteException(String message) {
        super(message);
    }
    
    public CommandExcuteException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public CommandExcuteException(Throwable cause) {
        super(cause);
    }
    
    CommandExcuteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
