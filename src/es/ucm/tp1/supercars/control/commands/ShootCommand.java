package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.control.Buyable;
import es.ucm.tp1.supercars.exceptions.CommandExcuteException;
import es.ucm.tp1.supercars.exceptions.CommandParseException;
import es.ucm.tp1.supercars.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.supercars.gameaction.ShootAction;;

public class ShootCommand extends Command implements Buyable {
	private static final String NAME = "shoot";

	private static final String DETAILS = "[s]shoot";

	private static final String SHORTCUT = "s";

	private static final String HELP = "shoot";

	private static final int Coste = 1;


	public ShootCommand() {
		// TODO Auto-generated constructor stub
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExcuteException{//comando para disparar (quita una vida al muro)
			
			try {
				ShootAction action = new ShootAction();//creamos nueva accion cual dispara
				buyable(game);
				game.execute(action);
				game.update();	
				
			}
			
			catch (NotEnoughCoinsException e) {
				  System.out.format(e.getMessage() + "%n%n");
		            throw new CommandExcuteException("[ERROR]: Failed to shoot ", e);	
			}
			
	
			return true;
		}

	@Override
	protected Command parse(String[] commandWords) throws CommandParseException {
		try {
		if ("s".equalsIgnoreCase(commandWords[0])) {
			commandWords[0] = SHORTCUT;
		}
		return super.parse(commandWords);}
		
		catch (CommandParseException e) {
			throw e;
		}
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return Coste;
	}

	
}
