package es.ucm.tp1.supercars.logic;

import java.util.ArrayList;
import java.util.List;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class GameObjectContainer{
	
	//private GameObject go;
	private Game game;
	private Level level;
	private List<GameObject> gameobjectsList;
	
	public GameObjectContainer(Game game, Level level) {
		gameobjectsList = new ArrayList<GameObject>();
		this.game = game;
		this.level = level;
	}

	
	public boolean isInthisPos ( int f , int c) {//busca si esta en esta posicion
		boolean ok = false;
		int i =0;
		while ( i < gameobjectsList.size() && !ok) {
			
			if (gameobjectsList.get(i).isInPosition(f, c) ) {
				ok = true;
			}
			i++;
		}
		return ok;
	}
	
	public String toString (int f, int c ) { //dibujar los symbol del obj
		String s ="";
		for (int i =0; i < gameobjectsList.size();i++) {
			
			if (gameobjectsList.get(i).isInPosition(f, c) ) { //isInthisPos ( int f , int c)
				s += gameobjectsList.get(i).toString();
			}
		}
		
		return s;
	}
	

	private GameObject getObjectOnPos(int x, int y) {//devuelve el objeto de determinada posicion
		
		int i = 0;
		boolean ok = false;
		
		while (!ok && i < gameobjectsList.size()) {
		
			GameObject g = gameobjectsList.get(i);
			
			if ( g.isInPosition(x, y)) {

				return g;
			}
			
			i++;
		}
			return null;
		}

	public Collider getCollliderPosition(int x, int y) {//si hay colision en x e y 
		
		
		return getObjectOnPos(x,y);
		
	}
	
	public void add (GameObject obj) {//añadir un nuevo obj en la lista
		gameobjectsList.add(obj);
		obj.onEnter();
	}
	
	public void update() {//actualizar la lista
		
		for ( int i = 0; i <gameobjectsList.size(); i++ ) {
			GameObject g = gameobjectsList.get(i);
			g.update();
		}
	}


	public void remove (GameObject obj) {///elimar obj de la lista 
		gameobjectsList.remove(obj);
		obj.onDelete();
	}
	
	public void clear (int x, int posPc, int y){//elima los obj de la ventana visible
		
		for ( int i =0; i < x; i++) {
			for ( int j = posPc; j < y; j++) {
				
				if ( this.getObjectOnPos(i, j) != null)
					remove(getObjectOnPos(i,j));

				
			}
		}
	}
	
	
	public boolean isAlive(int x , int y ) {//si esta vivo los obj 
		
		boolean alive = true;
		if(getObjectOnPos(x, y) != null) {
			if ( !this.getObjectOnPos(x,y).isAlive() ) {
			alive = false;
			}
		}
		return alive;
	}
	
	public String getSerializeStringInfoString (int x , int y) {
		String s = "";
		if ( this.getObjectOnPos(x, y) != null) {
		s += this.getObjectOnPos(x, y).getInfoSerialize();}
		return s;
	}

}
