package es.ucm.tp1.supercars.gameaction;

import es.ucm.tp1.supercars.exceptions.CommandExcuteException;
import es.ucm.tp1.supercars.logic.Game;

import es.ucm.tp1.supercars.logic.InstantAction;

public class ExplosionAction implements InstantAction {//accion que añade la granada

	private int x;
	private int y;
	
	public ExplosionAction ( int x, int y ) {
		
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void execute(Game game) throws CommandExcuteException { // cb
		
		game.addGrenade(this.x, this.y);
			
	}

}
