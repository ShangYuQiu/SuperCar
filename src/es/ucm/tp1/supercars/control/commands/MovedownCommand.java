package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.exceptions.CommandExcuteException;
import es.ucm.tp1.supercars.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;

public class MovedownCommand extends Command {

	private static final String NAME = "moveDown";

	private static final String DETAILS = "[a]moveDown";

	private static final String SHORTCUT = "a";

	private static final String HELP = "moveDown";

	public MovedownCommand(){
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExcuteException { //comando para mover hacia abajo
		// TODO add your code
		boolean a = false;
		
		if (!game.isFinished()) { //vemos que no esta acabado el juego
			a = true;
			
			game.avanza(); //primero avanzamos y luegos bajamos
			game.down();
			
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
