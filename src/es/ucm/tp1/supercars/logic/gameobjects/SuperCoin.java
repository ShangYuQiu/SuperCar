package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class SuperCoin extends GameObject {

	
	private static int numSuperCoin;
	public SuperCoin(Game game, int x, int y) {
		super(game, x, y);
		life = 1;
		numSuperCoin = 1;
		this.symbol = "$";
	}

	public static boolean hasSuperCoin() { // falta
		// TODO Auto-generated method stub
		return numSuperCoin == 1;
	}

	@Override
	public boolean doCollision() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		// TODO Auto-generated method stub
		player.addCoins(1000);
		life--;
		 
		
		return true;
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		numSuperCoin--;
		
	}

	public boolean receiveShoot() {
		return false;
	}

	@Override
	public boolean receiveExplosion() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getInfoSerialize() {
		String s = "";
		
		s += symbol + "(" + this.x + ","+ this.y + ")";
		return s;
	}

	@Override
	public void receiveWave() {
		// TODO Auto-generated method stub
		this.y += 1;
	}
	
}
