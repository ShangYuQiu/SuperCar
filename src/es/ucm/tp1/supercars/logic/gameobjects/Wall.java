package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Wall extends GameObject{

	public Wall(Game game, int x, int y) {
		super(game, x, y);
		this.life = 3;
		this.symbol = "█";
	}

	@Override
	public boolean doCollision() {
		
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {

		boolean ok = false;
		if (player.getPosF() == x && player.getPosC() == y) {
			ok = true;
			
			player.setlife();
			
			
		}
		return ok;
	}

	public boolean wallDestroyed () { // a lo mejor falta parametro
		boolean ok = false;
		
		if ( life == 0) {
			ok = true;
		}
		return ok;
	}
	@Override
	public void onEnter() {
		
	}

	@Override
	public void update() {
		setSymbol();
	}

	@Override
	public void onDelete() {
		
	}

	public void setSymbol () {
		if ( life == 3) {
			this.symbol = "█";

		}

		else if ( life == 2 ) {
			this.symbol = "▒";
		}
		
		else if ( life == 1) {
			this.symbol = "░";
		}

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
