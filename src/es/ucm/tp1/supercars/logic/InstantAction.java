package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.supercars.exceptions.CommandExcuteException;

public interface InstantAction {

	void execute (Game game) throws CommandExcuteException;
	
}
