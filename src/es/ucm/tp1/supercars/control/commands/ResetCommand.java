package es.ucm.tp1.supercars.control.commands;


import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.exceptions.CommandExcuteException;
import es.ucm.tp1.supercars.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;

public class ResetCommand extends Command {

	private static final String NAME = "Reset";

	private static final String DETAILS = "[r]Reset";

	private static final String SHORTCUT = "r";

	private static final String HELP = "Reset";
	
	private static int normal;
	
	private static long sem;
	
	private static String nivel;

	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {//comando para resetear juego
		// TODO add your code
		boolean a = false;
		if (!game.isFinished()) {
			a = true;
			Level niveles = Level.valueOfIgnoreCase(nivel);
			if(normal!=1) {
			game.reset(sem, niveles);//reseteamos para crear nueva partida
			}
			else game.resetNormal();//reset de la partida
		}
		return a;
		
		
	}

	@Override
	protected Command parse(String[] commandWords) throws CommandParseException {//si solo queremos resetear el juego devolvemos el shortcut, 
	
		try {
			
			if ( "r".equalsIgnoreCase(commandWords[0])) {
				commandWords[0] = SHORTCUT;
				normal = commandWords.length; // vemos si es reset normal o cambio de nivel y semilla
				if ( commandWords.length == 3) { // reset con cambio de nivel y semilla
					
					nivel = commandWords[1];
					
					if ( "EASY".equalsIgnoreCase(nivel) || "TEST".equalsIgnoreCase(nivel) 
							||"ADVANCED".equalsIgnoreCase(nivel) || "HARD".equalsIgnoreCase(nivel)) {
						
						try {
							
							sem = Integer.parseInt(commandWords[2]);
						}
						
						catch ( NumberFormatException ex) {
							System.out.println("[ERROR]: Command " + NAME + ": " + ex.getMessage());
				            throw new CommandParseException("[ERROR]: Command " + NAME + ": " + "Datos invalidos", ex);
						}
					}
					
					
					else {
						  throw new CommandParseException(String.format("[ERROR]: %s", "Unknown command"));
					}
			
			}
				
				return this;
			}
			
		}
		
		
		catch (CommandParseException e) {
			throw e;
		}
		return super.parse(commandWords);
	}	
}
