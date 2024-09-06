package es.ucm.tp1.supercars.control;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.exceptions.*;

public interface Buyable {

	public int cost();
	
	public default boolean buyable (Game game) throws CommandExcuteException {
		
		
		if(game.buy(cost())) 
		{
			return true;}
		else {
			throw new NotEnoughCoinsException("No tienes suficiente coin para comprar"); }
		
	};
}
