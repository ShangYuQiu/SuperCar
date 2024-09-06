package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;

public class ClearCommand extends Command {

	private static final String NAME = "Clear";

	private static final String DETAILS = "[0]clear";

	private static final String SHORTCUT = "0";

	private static final String HELP = "clear";
	
	public ClearCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) { //comando para borrar todo los objeto de la ventana(la parte visible)
	
		game.clearObj();
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
