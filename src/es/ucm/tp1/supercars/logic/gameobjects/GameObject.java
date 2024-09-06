package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public abstract class GameObject implements Collider {

	public static final String INFO = null;
	
	protected int x, y;

	protected Game game;

	protected String symbol;
	
	protected int life;

	public GameObject(Game game, int x, int y) {
		this.x = x;
		this.y = y;
		this.game = game;
	}
	
	public abstract void onEnter();

	public abstract void update();

	public abstract void onDelete();
	
	public abstract String getInfoSerialize();


	protected String getSymbol() {
		return symbol;
	}

	@Override
	public String toString() {
		if (isAlive()) {
			return getSymbol();
		}

		return "";
	}

	public boolean isInPosition(int x, int y) {
		return this.x == x && this.y == y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isAlive() {
		boolean ok = true;
		
		if ( life <= 0) {
			ok = false;
		}
		return ok;
	}
	
	



	// TODO add your code

}
