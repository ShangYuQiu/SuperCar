package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.exceptions.CommandExcuteException;
import es.ucm.tp1.supercars.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;

public class UpdateCommand extends Command {

	private static final String NAME = "update";

	private static final String DETAILS = "[n]one | []";

	private static final String SHORTCUT = "n";

	private static final String HELP = "update";

	public UpdateCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExcuteException {//comando para avanzar el jugador
	boolean a = false;
		
		if (!game.isFinished()) { //vemos que no esta acabado el juego
			a = true;
			
		game.avanza();//primero avanzamos luego bajamos
		game.update();//actualizamos
		}
		
		return a;
		}

	@Override
	protected Command parse(String[] commandWords) throws CommandParseException {
		try {
		if ("n".equalsIgnoreCase(commandWords[0])
				|| "".equalsIgnoreCase(commandWords[0])) {
			commandWords[0] = SHORTCUT;
		}
		return super.parse(commandWords);
		}
		catch ( CommandParseException e) {
			throw e;
		}
	}
}
