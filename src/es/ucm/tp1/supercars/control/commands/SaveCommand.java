package es.ucm.tp1.supercars.control.commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import es.ucm.tp1.supercars.exceptions.CommandExcuteException;
import es.ucm.tp1.supercars.exceptions.CommandParseException;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.view.GameSerializer;

public class SaveCommand extends Command{
	
	
	private static final String NAME = "Save";

	private static final String DETAILS = " Sa[v]e";

	private static final String SHORTCUT = "v";

	private static final String HELP = "Save";
	
	private String file;
	
	private static final String FILEEXTENSION = ".txt";

	public SaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExcuteException { // guarda el estado de una partida
		
		try {
			save( this.file, game);
		}
		
		catch ( Exception e) {
			System.out.println(e);
			 throw new CommandExcuteException("[ERROR]: failed to save the game", e);
		}

		
		return true;
	}
	
	@Override
	protected Command parse(String[] commandWords) throws CommandParseException {
		
		if ("v".equalsIgnoreCase(commandWords[0])) {
			commandWords[0] = SHORTCUT;
			
			
			if (commandWords.length == 2) {
				file = commandWords[1];
			}
			
			else {
	            throw new CommandParseException("[ERROR]: Command " + NAME + " : " + INCORRECT_NUMBER_OF_ARGS_MSG);
	        }
			return this;
			
			
		}
		
		return super.parse(commandWords);
		
	}
	
	public void save (String file, Game g) throws IOException {
		
		BufferedWriter outFileBufferedWriter = null;
		GameSerializer serializer = new GameSerializer(g);
		try {
			String s = "";
			outFileBufferedWriter = new BufferedWriter( new FileWriter(this.file + FILEEXTENSION));
			s = serializer.getInfo();
			outFileBufferedWriter.append(s);
		}

		finally {
			if ( outFileBufferedWriter != null) {
				outFileBufferedWriter.close();
			}
		}
	}
	
	

}
