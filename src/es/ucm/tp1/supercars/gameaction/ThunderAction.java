package es.ucm.tp1.supercars.gameaction;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.InstantAction;

public class ThunderAction implements InstantAction {

	
	private int x;
	private int y;
	private static String hit;
	
	@Override
	public void execute(Game game) {//generamos un trueno en el pos x e y aleatoriamente
		// TODO Auto-generated method stub
		
		this.x = game.getRandomLane();
		this.y = game.getPositionPc() + game.getRandomC() ;
		hit = game.getPositionToString(x, y);//indica el objeto atacado
		
		if ( game.getObjectOnPos(x, y) != null && game.getObjectOnPos(x, y).receiveShoot()) {//que no sea vacio, y que sea un obj que se pueda atacar
			
			
			
			
			System.out.println("Thunder hit position: ("+x+" , "+(y - game.getPositionPc())+") -> "+hit+" hit");
			game.removes(game.getObjectOnPos(x, y));
			
		}
		
		else {
			System.out.println("Thunder hit position: ("+x+" , "+ (y - game.getPositionPc())+")");
		}
	}

}
