package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Pedestrian extends GameObject {

	private boolean up;
	
	public Pedestrian(Game game, int x, int y) {
		super(game, x, y);
		this.symbol ="☺";
		life = 1;
		up = false;
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
			
		}
		return ok;
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		
		
		if ( x == game.getWidth() -1) {
			up = true;
			this.x--;
			
		}
		else if ( x == 0) {
			up = false;
			this.x++;
		}
		
		else if (!up) {
			this.x++;
		}
		
		else if ( up) {
			this.x--;
		}

		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean receiveExplosion() {
		life--;
		game.setPlayerCoin(game.playerCoins());
		return true;
	}

	@Override
	public boolean receiveShoot() {
		life =0;
		game.setPlayerCoin(-game.playerCoins());
		return true;
	}


	@Override
	public String getInfoSerialize() {
		String s = "";
		
		s += symbol + "(" + this.x + ","+ this.y + ")" +" ";
		
		if ( up) {
			
			s += "up";
		}
		
		else {
			s += "down";
		}
		
		return s;
	}


	@Override
	public void receiveWave() {
		// TODO Auto-generated method stub
		this.y += 1;
	}

	
}
