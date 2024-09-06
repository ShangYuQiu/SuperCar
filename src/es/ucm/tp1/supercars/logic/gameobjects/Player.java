package es.ucm.tp1.supercars.logic.gameobjects;


import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.control.Level;
//import org.omg.CORBA.PUBLIC_MEMBER;

public class Player {

	private int posF, posC;
	private Game game;
	private int life;
	private int nCoin;
	private static final String symbolAlive = " > ";
	private static final String symbolDead = " @ ";
	public Player(Game game, int posF, int posC) {
		this.posC = posC;
		this.posF = posF;
		this.game = game;
		this.life = 1;

	}

	public boolean isInThisPosition(int f, int c) {
		return (this.posF == f) && (this.posC == c); // Si est�� en la coordenada f, c => true
	}

	public String toString() { // devuelve el simbolo dependiendo si etsa vivo o muerto

		if(this.dead()) {
			return symbolDead;
		}
		else {
		return symbolAlive;
		}
	}

	public int getPosF() { // obtiene la fila que esta el jug
		return posF;
	}

	public int getPosC() { // obtiene la col que esta el jug
		return posC;
	}
	
	public int getNumCoin () { // devuelve el num de coin obtenido
		return nCoin;
	}

	public boolean up() { // realiza el mov de arriba y comprueba que no se sale
		boolean ok = true;

		if (posF - 1 < 0) {
			ok = false;
		} else {
			this.posF -= 1;
		}

		return ok;
	}

	public boolean down(Level level) { // realiza el mov de abajo y comprueba que no se sale

		boolean ok = true;

		if (posF + 1 >= level.getWidth() ) {
			ok = false;
		} else {
			this.posF += 1;
		}

		return ok;
	}
	
	
	public void updateP() {
		posC += 1;
	}
	
	
	public void addCoins(int x) {
		
		nCoin += x;
	}
	public boolean doCollision () {
		Collider other = game.getObjectOnPos(posF, posC);
		
		if ( other != null ) {
			return other.receiveCollision(this);
		}

		return false;
	}
	
	public boolean dead() {
		boolean ok = false;
		
		if ( life <= 0) {
			ok = true;
		}
		return ok;
	}
	
	public void setlife() {
		life--;
	}
	
	public void setPos ( int n) {
		posC += n;
	}
	
	
}

