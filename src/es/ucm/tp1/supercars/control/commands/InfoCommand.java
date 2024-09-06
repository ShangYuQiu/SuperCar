package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;


public class InfoCommand extends Command {

	private static final String NAME = "info";

	private static final String DETAILS = "[i]nfo";

	private static final String SHORTCUT = "i";

	private static final String HELP = "prints gameobject info";

	public InfoCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	private static final String[] INFO_MSG = new String[] {// comando para mostrar informacion pos pantalla
			"[DEBUG] Executing: i",
			"Available objects:",
			"[Car] the racing car",
			"[Coin] gives 1 coin to the player",
			"[Obstacle] hits car",
			"[GRENADE] Explodes in 3 cycles, harming everyone around",
			"[WALL] hard obstacle",
			"[TURBO] pushes the car 3 columns",
			"[SUPERCOIN] gives 1000 coins",
			"[TRUCK] moves towards the player",
			"[PEDESTRIAN] person crossing the road up and down"	,
			"[Serialize]: Serializes the board",
			"[Save] <filename>: Save the state of the game to a file",
			"[dump] <filename>: Shows the content of a saved file",
			"rec[o]rd: show level record"

		};

	@Override
	public boolean execute(Game game) {
		StringBuilder buffer = new StringBuilder("Available commands:");
		 for (int i = 0;i< INFO_MSG.length;i++) {
				System.out.println(INFO_MSG[i]);			
	}
// crear en game los helps
		
		System.out.println(buffer.toString());

		return false;
	}

		
	

	

}