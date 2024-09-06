package es.ucm.tp1.supercars.gameaction;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.InstantAction;

public class WaveAction implements InstantAction{

	@Override
	public void execute(Game game) {//desplaza todo los obj hacia la derecha 1,siempre cuando este vacio
		
		for ( int i = 0; i < game.getWidth(); i++) {
			
			for ( int j = game.getPositionPc()+ game.getVisibility() -1; j >= game.getPositionPc(); j--) {
				
				if ( game.getObjectOnPos(i, j) != null && game.getObjectOnPos(i, j +1 ) == null) {//no sea objeto vacio y haya espacio para desplazar

					game.getObjectOnPos(i, j).receiveWave();
				}
			}
		}
	}

}
