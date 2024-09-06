package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.exceptions.CommandExcuteException;
import es.ucm.tp1.supercars.gameaction.ThunderAction;
import es.ucm.tp1.supercars.logic.gameobjects.Coin;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;
import es.ucm.tp1.supercars.logic.gameobjects.Grenade;
import es.ucm.tp1.supercars.logic.gameobjects.Obstacle;
import es.ucm.tp1.supercars.logic.gameobjects.Wall;
import es.ucm.tp1.supercars.logic.gameobjects.Turbo;
import es.ucm.tp1.supercars.logic.gameobjects.Truck;
import es.ucm.tp1.supercars.logic.gameobjects.SuperCoin;
import es.ucm.tp1.supercars.logic.gameobjects.Pedestrian;

// TODO add your imports

public class GameObjectGenerator {

	public static void generateGameObjects(Game game, Level level) {//generador de obj iniciales

		for (int x = game.getVisibility() / 2; x < game.getLength(); x++) {

			game.tryToAddObject(new Obstacle(game, game.getRandomLane(), x), game.getObsFrenc());
			game.tryToAddObject(new Coin(game, game.getRandomLane(), x), game.getCoinFrenc());

			if (level.hasAdvancedObjects()) {
				game.tryToAddObject(new Wall(game, game.getRandomLane(), x), level.advancedObjectsFrequency());
				game.tryToAddObject(new Turbo(game, game.getRandomLane(), x), level.advancedObjectsFrequency());
				if (!SuperCoin.hasSuperCoin()) {
					game.tryToAddObject(new SuperCoin(game, game.getRandomLane(), x), level.advancedObjectsFrequency());
				}
				game.tryToAddObject(new Truck(game, game.getRandomLane(), x), level.advancedObjectsFrequency());
				game.tryToAddObject(new Pedestrian(game, 0, x), level.advancedObjectsFrequency());
			}

		}

	}

	public static void reset(Level level) {//reseteamos los obj
		Obstacle.reset();
		Coin.reset();
	}

	public static void generateRuntimeObjects(Game game) throws CommandExcuteException {//generamos thunder
		if (game.getLevel().hasAdvancedObjects()) {
			game.execute(new ThunderAction());
		}
	}

	public static void generateGrenade(Game game, int x, int y) {//generamos la granada en la pos x e y que le indiquemos 
		game.tryToAddObject(new Grenade(game, x, y), 1);
	}

	public static void forceAdvanceObject(Game game, int id, int x) {//los obj que añadiremos por cheatcommand
		GameObject o = null;
		switch (id) {
		case 1:
			o = new Wall(game, game.getRandomLane(), x);
			break;
		case 2:
			o = new Turbo(game, game.getRandomLane(), x);
			break;
		case 3:
			o = new SuperCoin(game, game.getRandomLane(), x);
			break;
		case 4:
			o = new Truck(game, game.getRandomLane(), x);
			break;
		case 5:
			o = new Pedestrian(game, 0, x);
			break;
		}
		game.forceAddObject(o);
	}

}
