package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.exceptions.CommandExcuteException;
import es.ucm.tp1.supercars.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;

public class SerializeCommand extends Command{

	
	private static final String NAME = "Serialize";

	private static final String DETAILS = " Seriali[z]e";

	private static final String SHORTCUT = "z";

	private static final String HELP = "Serialize";
	
	public SerializeCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) { // muestra el estado de una partida y sus objetos existentes
		
		System.out.println( game.getAllInfoString());
		
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
