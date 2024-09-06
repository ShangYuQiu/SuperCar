package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.control.Buyable;
import es.ucm.tp1.supercars.exceptions.CommandExcuteException;
import es.ucm.tp1.supercars.exceptions.CommandParseException;
import es.ucm.tp1.supercars.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.supercars.gameaction.WaveAction;

public class WaveCommand extends Command implements Buyable {

	
	private static final String NAME = "wave";

	private static final String DETAILS = "[w]wave";

	private static final String SHORTCUT = "w";

	private static final String HELP = "wave";
	
	private static final int Coste = 5;


	public WaveCommand() {
		// TODO Auto-generated constructor stub
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExcuteException {//comando para empujar todo los objeto hacia atras
		//comprobamos que no este acabado 

			try {
			WaveAction action = new WaveAction();//creamos nueva accion
			buyable(game); //si se puede comprar esta habilidad
			game.execute(action);
			game.update(); //actualizamos
			}
			catch (NotEnoughCoinsException e) {
			
				 System.out.format(e.getMessage() + "%n%n");
		            throw new CommandExcuteException("[ERROR]: Failed to wave ", e);
			}
			

		return true;
	
		}

	@Override
	protected Command parse(String[] commandWords) throws CommandParseException {
		try {
			return super.parse(commandWords);}
		
		catch (CommandParseException e) {
			throw e;
		}
	}

	@Override
	public int cost() {
		
		return Coste;
	}

}
