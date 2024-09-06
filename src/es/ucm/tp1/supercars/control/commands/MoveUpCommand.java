package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.exceptions.CommandExcuteException;
import es.ucm.tp1.supercars.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;

public class MoveUpCommand extends Command {

	private static final String NAME = "MoveUp";

	private static final String DETAILS = "[q]MoveUp";

	private static final String SHORTCUT = "q";

	private static final String HELP = "MoveUp";

	public MoveUpCommand(){
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExcuteException { //comando para mover hacia arriba
	boolean a = false;
		
		if (!game.isFinished()) { //vemos que no esta acabado el juego
			a = true;
			
		game.avanza();//primero avanzamos luego bajamos
		game.up();
		
		game.update();//actualizamos
		}
		
		return a;
	}

	@Override
	protected Command parse(String[] commandWords) throws CommandParseException {
		try{
			return super.parse(commandWords);
			}
		catch (CommandParseException e) {
			throw e;
		}
	}
}
