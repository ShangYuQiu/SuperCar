package es.ucm.tp1.supercars.gameaction;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.InstantAction;


public class ShootAction implements InstantAction {

	@Override
	public void execute(Game game) {//accion del disparo
		
		
		boolean ok = false;
		int i = game.getPositionPc() + 1 ;
		while ( i < game.getPositionPc() + game.getVisibility() && !ok) {
			if (game.getObjectOnPos(game.getPositionPf(), i) != null) {
				if (game.getObjectOnPos(game.getPositionPf(), i).receiveShoot()) {//vemos si es objeto disparable
				ok = true;
				if (!game.isAlive(game.getPositionPf(), i)) { 
						game.removes(game.getObjectOnPos(game.getPositionPf(), i)); 
					}
					}
				}

			i++;
			
		}
		
	}
}
