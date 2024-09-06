package es.ucm.tp1.supercars.view;


import es.ucm.tp1.supercars.logic.Game;

public class GameSerializer {

	private Game game;
	
	public GameSerializer ( Game game) {
		this.game = game;
	}
	
	public String getInfo () {
		String s ="";
		
		s += "---- ROAD FIGHTER SERIALIZED ---- " +"\n";
		s += "Level:" + game.getLevel() + "\n";
		s += "Game Objects:" + " \n";
		s += "Cycles:" + game.getCycle() + " \n";
		s += "Coins:" + game.playerCoins()+ "\n";
		s += game.getPlayerSymbol() + "(" +game.getPositionPf() + "," + game.getPositionPc() + ")" + "\n";
		for ( int y =0 ; y< game.getLength(); y++) {
			for (int x = 0; x < game.getWidth(); x++) {
				if ( game.getObjectOnPos(x, y) != null) {
				s += game.getSerializeInfoString(x, y) +"\n";}
			}
		}
		return s;
	}
	
	
}
