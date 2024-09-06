package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;

public class ExitCommand extends Command {

	private static final String NAME = "update";

	private static final String DETAILS = "[e] exit";

	private static final String SHORTCUT = "e";

	private static final String HELP = "exit";

	public  ExitCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {//comando para la salida del juego
		// TODO add your code
			
		game.setExit();
		
		return true;
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
