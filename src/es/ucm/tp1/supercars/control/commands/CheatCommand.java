package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;

public class CheatCommand extends Command {

	
	private static final String NAME = "cheat";

	private static final String DETAILS = "[1] || [2] || [3] || [4] || [5]";

	private static final String SHORTCUT = "1";

	private static final String HELP = "cheat";
	
	private static int idCheat;
	
	public CheatCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) { //comando para añadir obj a la fuerza

		game.cheat(idCheat);
		return true;
	}
 
	@Override
	protected Command parse(String[] commandWords) throws CommandParseException { //dirente opciones posivle de 1 a 5
		try {
			if (
				  "1".equalsIgnoreCase(commandWords[0])  //muro
				||"2".equalsIgnoreCase(commandWords[0])  //turbo
				||"3".equalsIgnoreCase(commandWords[0])  //supercoin
				||"4".equalsIgnoreCase(commandWords[0])  //track
				||"5".equalsIgnoreCase(commandWords[0])) //pedestrian
			{
				idCheat = Integer.parseInt(commandWords [0]); //guardar la opcion introducida

				return this;
			}
			
			return super.parse(commandWords);}
		
		catch (CommandParseException e) {
			throw e;
		}
	}
}
