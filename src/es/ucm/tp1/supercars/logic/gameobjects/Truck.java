package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Truck extends GameObject {

	public Truck(Game game, int x, int y) {
		super(game, x, y);
		life = 1;
		this.symbol = "←";
	}

	@Override
	public boolean doCollision() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		
		boolean ok = false;
		if (player.getPosF() == x && player.getPosC() == y) {
			ok = true;
			player.setlife();
			life--;
			
		}
		return ok;
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() { // llamarlo en algun sitio
		y-- ;
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		this.y += 1;
	}
}
