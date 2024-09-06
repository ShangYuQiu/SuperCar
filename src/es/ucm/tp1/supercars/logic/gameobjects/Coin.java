package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Coin extends GameObject{

	private static int numCoin;
	private final static int valorCoin = 1;//esta bien poner esto?
	
	public Coin(Game game, int x, int y) {
		super(game, x, y);
		this.symbol = "¢";
		this.life = 1;
	}

	@Override
	public boolean doCollision() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		
			player.addCoins(valorCoin);
			life--;

		
		return true;
	}

	@Override
	public void onEnter() {
		
		numCoin++;
	}

	@Override
	public void update() {
	}

	@Override
	public void onDelete() {
		numCoin--;
		
	}

	public static int getCoinsCount() {
		return numCoin;
	}
	
	public static void reset () {
		numCoin = 0;
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
		
		s += symbol + "(" + x + "," + y + ")";
		return s;
	}

	@Override
	public void receiveWave() {
		
		this.y += 1;
		
	}


	
}
