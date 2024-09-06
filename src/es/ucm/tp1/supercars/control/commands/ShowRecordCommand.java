package es.ucm.tp1.supercars.control.commands;


import es.ucm.tp1.supercars.exceptions.CommandExcuteException;
import es.ucm.tp1.supercars.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;

public class ShowRecordCommand extends Command{

	
	private static final String NAME = "Dump";

	private static final String DETAILS = " rec[o]rd";

	private static final String SHORTCUT = "o";

	private static final String HELP = "Record";
	
	public ShowRecordCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExcuteException {
		
		long record;
		
		record = game.getRecord();
		
		System.out.println(game.getLevel() + " record is " +record + " s");
		
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
