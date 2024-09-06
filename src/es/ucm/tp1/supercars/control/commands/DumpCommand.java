package es.ucm.tp1.supercars.control.commands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import es.ucm.tp1.supercars.exceptions.CommandExcuteException;
import es.ucm.tp1.supercars.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;

public class DumpCommand extends Command{

	
	private static final String NAME = "Dump";

	private static final String DETAILS = " [d]ump";

	private static final String SHORTCUT = "d";

	private static final String HELP = "Dump";
	
	private String readFile;
	
	private static final String FILEEXTENSION = ".txt";
	
	public DumpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		
	}

	@Override
	public boolean execute(Game game) throws CommandExcuteException { //vuelca el contenido de un fichero en la consola

		try {
			dump( this.readFile);
		}
		
		catch ( Exception e) {
			System.out.println(e);
			 throw new CommandExcuteException("[ERROR]: failed to read the file", e);
		}
		
		
		return true;
		
	}
	
	@Override
	protected Command parse(String[] commandWords) throws CommandParseException {
		
		if ("d".equalsIgnoreCase(commandWords[0])) {
			commandWords[0] = SHORTCUT;
			
			if (commandWords.length == 2) {
			readFile = commandWords[1];
			}
			
			else {
	            throw new CommandParseException("[ERROR]: Command " + NAME + " : " + INCORRECT_NUMBER_OF_ARGS_MSG);
	        }

			return this;
		}

		
		return super.parse(commandWords);
	}
	
	public void dump (String file) throws IOException{
		
		BufferedReader inFileBufferedReader = null;
		
		try {
			inFileBufferedReader = new BufferedReader( new FileReader(file + FILEEXTENSION));
			
			String l;
			while ((l = inFileBufferedReader.readLine()) != null) {
				System.out.println(l);
			}
		}
		
		finally {
			if ( inFileBufferedReader != null) {
				inFileBufferedReader.close();
			}
		}
	}

}
