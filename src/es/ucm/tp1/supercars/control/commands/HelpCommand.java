package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class HelpCommand extends Command {

	private static final String NAME = "help";

	private static final String DETAILS = "[h]elp";

	private static final String SHORTCUT = "h";

	private static final String HELP = "show this help";

	public HelpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	private static final String[] HELP_MSG = new String[] { //comando para mostrar pantalla esta informacion
			"Available commands:",
			"[h]elp: show this help",
			"[i]nfo: prints gameobjet info",
			"[n]one | []: update",
			"[q]: go up",
			"[a]: go down",
			"[e]xit: exit game",
			"[r]eset: reset game",
			"[t]est: enables test mode",
			"[s]hoot: shoot bullet",
			"[g]renade <x> <y>: add a grenade in position x, y",
			"[w]ave: do wave\n",
			"Clear [0]: Clears the road",
			"seriali[z]e: Serializes the board",
			"sa[v]e <filename>: Save the state of the game to a file",
			"[d]ump <filename>: Shows the content of a saved file",
			"rec[o]rd: show level record",
			"Cheat [1..5]: Removes all elements of last visible column, and adds an Advanced Object"
			
		};

	@Override
	public boolean execute(Game game) {
		StringBuilder buffer = new StringBuilder("Available commands:");
		 for (int i = 0;i< HELP_MSG.length;i++) {
				System.out.println(HELP_MSG[i]);			
	}
// crear en game los helps
		
		System.out.println(buffer.toString());

		return false;
	}

}
