package es.ucm.tp1.supercars.exceptions;

public class GameException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2315357236534893685L;

	
	public GameException () {
		super();
	}
	
    public GameException(String message) {
        super(message);
    }
    
    public GameException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public GameException(Throwable cause) {
        super(cause);
    }
    
    GameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
