package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Obstacle extends GameObject {

	
	private static int numObs;
	public Obstacle(Game game, int x, int y) {
		super(game, x, y);
		symbol = "░";
		this.life = 1;
	}



	@Override
	public void onEnter() {
		numObs++;
		
	}


	@Override
	public void onDelete() {
		numObs--;
		
	}



	@Override
	public boolean doCollision() {
		
		return false;
	}



	@Override
	public boolean receiveCollision(Player player) {
		

			player.setlife();
			

		return true;
	}



	@Override
	public void update() {
		
	}



	public static int getObstaclesCount() {
		
		return numObs;
	}

	public static void reset () {
		numObs = 0;
	}

	public boolean receiveShoot() {
		life--;
		return true;
	}

	@Override
	public boolean receiveExplosion() {

		life =0;
		return true;
	}



	@Override
	public String getInfoSerialize() {
		String s = "";
		
		s += symbol + "(" + this.x + ","+ this.y + ")";
		
		return s;
	}

	@Override
	public void receiveWave() {
		this.y += 1;
	}

	
}
