package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.exceptions.*;

public abstract class Command {

	private static final String UNKNOWN_COMMAND_MSG = "Unknown command";

	protected static final String INCORRECT_NUMBER_OF_ARGS_MSG = "Incorrect number of arguments";
	
	
	private final String name;

	private final String shortcut;

	private final String details;

	private final String help;

	public Command(String name, String shortcut, String details, String help) {
		this.name = name;
		this.shortcut = shortcut;
		this.details = details;
		this.help = help;
	}

	/* @formatter:off */
	protected static final Command[] AVAILABLE_COMMANDS = {
		new HelpCommand(),
		new InfoCommand(),
		new UpdateCommand(),
		new MovedownCommand(),
		new MoveUpCommand(),
		new ResetCommand(),
		new ExitCommand(),
		new ShootCommand(),
		new GrenadeCommand(),
		new WaveCommand(),
		new CheatCommand(),
		new ClearCommand(), 
		new SaveCommand(),  
		new SerializeCommand(),
		new DumpCommand(),
		new ShowRecordCommand()
	};
	/* @formatter:on */

	public static Command getCommand(String[] commandWords) throws CommandParseException{
		Command command = null;
		boolean ok = false;
		int i =0;
		
		while (i < AVAILABLE_COMMANDS.length && !ok) {
			
			if (AVAILABLE_COMMANDS[i].parse(commandWords) != null){
				ok = true;
				command = AVAILABLE_COMMANDS[i];
			}
			i++;
		}
		
		
		if (!ok) {
			throw new CommandParseException (String.format("[ERROR]: %s%n%n", UNKNOWN_COMMAND_MSG));
			}
		return command;
	}

	public abstract boolean execute(Game game) throws CommandExcuteException;

	protected boolean matchCommandName(String name) {
		return this.shortcut.equalsIgnoreCase(name) || this.name.equalsIgnoreCase(name);
	}

	protected Command parse(String[] words) throws CommandParseException  {
		if (matchCommandName(words[0])) {
			if (words.length != 1) {
				throw new CommandParseException(String.format("[ERROR]: Command %s: %s%n%n", name, INCORRECT_NUMBER_OF_ARGS_MSG));
				
			} else {
				return this;
			}
		}
		return null;
	}
	
	// TODO Add your code

}
