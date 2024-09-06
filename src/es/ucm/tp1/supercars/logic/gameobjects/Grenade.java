package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Grenade extends GameObject {

	public Grenade(Game game, int x, int y) {
		super(game, x, y);
		this.life = 4;
		setSymbol();
	}

	@Override
	public boolean doCollision() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {

		
		this.life--;
		setSymbol();
		if(!this.isAlive()) {
			
			// explosion action = new...
			game.explosion(this.x, this.y);
			
		}
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub

	}

	public boolean receiveShoot() {
		return false;
	}

	public void setSymbol() {
		symbol = "ð ["+life+"]";
	}

	@Override
	public boolean receiveExplosion() {
		life =0;
		return true;
	}

	@Override
	public String getInfoSerialize() {
		String s = "";
		
		s += symbol + "(" + this.x + ","+ this.y + ")" + life;
		return s;
	}

	@Override
	public void receiveWave() {
		this.y += 1;
	}


}
