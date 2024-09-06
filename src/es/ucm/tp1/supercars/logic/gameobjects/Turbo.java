package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Turbo extends GameObject{

	public Turbo(Game game, int x, int y) {
		super(game, x, y);
		// TODO Auto-generated constructor stub
		this.life = 1;
		this.symbol =">>>";
	}

	@Override
	public boolean doCollision() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		// TODO Auto-generated method stub
		
		player.setPos(3);
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
		
	}

	public boolean receiveShoot() {
		return false;
	}

	@Override
	public boolean receiveExplosion() {
		life --;
		return true;
	}

	@Override
	public String getInfoSerialize() {
		String s = "";
		
		s += symbol + "(" + this.x + ","+ this.y + ")" ;
		return s;
	}

	@Override
	public void receiveWave() {
		
		this.y += 1;
	}
	
}
