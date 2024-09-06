package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.control.Buyable;
import es.ucm.tp1.supercars.exceptions.CommandExcuteException;
import es.ucm.tp1.supercars.exceptions.CommandParseException;
import es.ucm.tp1.supercars.exceptions.InvalidPositionException;
import es.ucm.tp1.supercars.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.supercars.gameaction.ExplosionAction;
import es.ucm.tp1.supercars.logic.Game;

public class GrenadeCommand extends Command implements Buyable{

	
	
	private static final String NAME = "grenade";

	private static final String DETAILS = "[g]grenade";

	private static final String SHORTCUT = "g";

	private static final String HELP = "grenade";
	
	private static final int Coste = 3;

	//private boolean ok =true;
	
	private int PosGf;
	
	private int PosGc;

	public GrenadeCommand() {
		// TODO Auto-generated constructor stub
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExcuteException  {//comando para vrear la granado en determinado posicion
			
		try {
			ExplosionAction action = new ExplosionAction(PosGf, PosGc + game.getPositionPc());
			buyable(game);
			game.execute(action);
			game.update();
		}
		
		catch (InvalidPositionException e) {

			System.out.format(e.getMessage() + "%n%n");
			 throw new CommandExcuteException("[ERROR]: Failed to add grenade", e);
		}
		
		catch ( NotEnoughCoinsException ex) {
			System.out.format(ex.getMessage() + "%n%n");
			 throw new CommandExcuteException("[ERROR]: Failed to add grenade", ex);
		}

		return true;
	
		}

	@Override
	protected Command parse(String[] commandWords) throws CommandParseException {//en caso de que solo queremos empezar de nuevo length = 1; es decir con el shortcup, 
		
		try {
		if ("g".equalsIgnoreCase(commandWords[0])) {//y si queremos nueva partida, entonces r, nuevo nivel y nueva semilla
			commandWords[0] = SHORTCUT;
			 if ( commandWords.length == 3) {
				 
				 try {
				PosGf = Integer.parseInt(commandWords [1]);
				PosGc = Integer.parseInt(commandWords [2]);}
				 
				catch ( NumberFormatException e) {
					System.out.println("[ERROR]: Command " + NAME + ": " + e.getMessage());
		            throw new CommandParseException("[ERROR]: Command " + NAME + ": " + "Datos invalidos", e);
				} 
				//ok=true;
				return this;
			}
		
			}
		}
		catch (CommandParseException e) {
			throw e;
		}
		return super.parse(commandWords);
	}
	
	@Override
	public int cost() {
		return Coste;
	}

	
}
