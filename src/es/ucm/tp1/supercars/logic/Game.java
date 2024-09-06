package es.ucm.tp1.supercars.logic;


import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.exceptions.CommandExcuteException;
import es.ucm.tp1.supercars.exceptions.InvalidPositionException;
import es.ucm.tp1.supercars.logic.gameobjects.*;
import es.ucm.tp1.supercars.logic.gameobjects.Player;
import es.ucm.tp1.supercars.view.GamePrinter;
import es.ucm.tp1.supercars.view.GameSerializer;

import java.io.IOException;
import java.util.Random;


// Nombre : Zhenbo Chen , ShangYu Qiu, 2D

public class Game {
	private GameObjectContainer gameContainer;
	private GamePrinter printer;
	private Player player;
	private Long seed;
	private Level level;
	private Random r;
	private int cycle;
	private boolean test;
	private long currenttime;
	private long timetotal;
	private boolean exit;
	private long nowtime;
	private GameSerializer serializer;
	private Record _record;

	public Game(Long seed, Level level) {

		this.player = new Player(this, level.getWidth() / 2, 0);
		this.seed = seed;
		this.level = level;
		this.r = new Random(seed);
		this.test = false;
		gameContainer = new GameObjectContainer(this, level);
		GameObjectGenerator.generateGameObjects(this, level);
		cycle = 0;
		exit = false;
		this.currenttime = System.currentTimeMillis();
		this.nowtime = System.currentTimeMillis();

		this.serializer = new GameSerializer(this);
		
		try {
			_record = new Record(this);
		} catch (IOException | CommandExcuteException e) {
			this.setExit();
			System.out.println(e.getMessage());
		}
	}

	public void resetNormal() {
		
		GameObjectGenerator.reset(level);
		cycle = 0;
		this.player = new Player(this, level.getWidth() / 2, 0);
		this.r = new Random(seed);
		this.test = false;
		gameContainer = new GameObjectContainer(this, level);
		GameObjectGenerator.generateGameObjects(this, level);
		this.currenttime = System.currentTimeMillis();
		this.nowtime = System.currentTimeMillis();
		exit = false;
		this.serializer = new GameSerializer(this);

		try {
			_record = new Record(this);
			
		} catch (IOException | CommandExcuteException e) {
			this.setExit();
			System.out.println(e.getMessage());
		}
	}

	public void reset(Long seed, Level level) {// resetea el juego

		GameObjectGenerator.reset(level);
		this.currenttime = System.currentTimeMillis();
		this.nowtime = System.currentTimeMillis();
		this.player = new Player(this, level.getWidth() / 2, 0);
		this.seed = seed;
		this.level = level;
		this.r = new Random(seed);
		this.test = false;
		gameContainer = new GameObjectContainer(this, this.level);
		GameObjectGenerator.generateGameObjects(this, this.level);
		cycle = 0;
		exit = false;
		this.serializer = new GameSerializer(this);

		try {
			_record = new Record(this);
		} catch (IOException | CommandExcuteException e) {
			this.setExit();
			System.out.println(e.getMessage());
		}
	}

	public String getPositionToString(int f, int c) { // comprueba si hay objetos en la posicion f,c y lo imprime
		String r = "";

		if (player.isInThisPosition(f, c)) {// si esta el jugador
			r = player.toString();
		}

		
		if (gameContainer.isInthisPos(f, c)) {
			r += gameContainer.toString(f, c);
		}
		
		if (c == level.getLength() - 1) {
			r += "¦";
		}


		return r;
	}

	public int getRandomLane() { // genera un numero aleatorio de 0 hasta las num filas
		int rand = r.nextInt(getWidth());

		return rand;
	}

	public int getRandomC() { // genera un numero aleatorio de 0 hasta las num columnas

		int ran = r.nextInt(getVisibility());

		return ran;
	}

	public void tryToAddObject(GameObject obj, double frec) { //añadimos objetos
		if (r.nextDouble() < frec) {

			if (gameContainer.getCollliderPosition(obj.getX(), obj.getY()) == null //vemos is esta vacio para añadir el objeto
					&& !player.isInThisPosition(obj.getX(), obj.getY())) {
				gameContainer.add(obj);
			}
		}
	}

	public boolean win() { // comprueba si ha ganado (si ha llegado a la meta)

		boolean ok = false;
		if (player.getPosC() == level.getLength() - 1) {
			ok = true;
			long nowatime = System.currentTimeMillis();
			 this.timetotal = (nowatime - this.currenttime) / 1000;
			System.out.println("TOTAL TIME: " + timetotal + " s");
			_record.newRecord();
		}

		return ok;
	}

	public boolean dead() { // comprueba si esta muerto (si ha chocado con algun obstaculo)
		return player.dead();
	}

	public void update() throws CommandExcuteException {//actualizamos todo

		nowtime = System.currentTimeMillis();
		comprobar();
		cycle++;
		gameContainer.update();
		comprobar();
		GameObjectGenerator.generateRuntimeObjects(this);

	}

	public void avanza() {//avanza el jugador

		comprobar();//comprobamos si se chocaa
		player.updateP();

	}

	public void comprobar() {//comprueba el obj que se enfrenta el jugador y si es una moneda se lo come, si es otro objeto realizara otra funcionalidad (morir) 
		if (player.doCollision()) {
			Collider go = getObjectOnPos(player.getPosF(), player.getPosC());
			if (!this.isAlive(player.getPosF(), player.getPosC())) { // ! alive
				removes(go);
			}

		}

		
	}

	public void removes(Collider go) {//eliminar obj
		gameContainer.remove((GameObject) go);
	}
	

	public void clearObj() {//elimina todo los objetos que se encuentre en la ventana (parte visible)
		gameContainer.clear(getWidth(), getPositionPc(), getPositionPc() + getVisibility());
	}

	public void cheat(int id) {//elimina la ultima columna de la ventana visible y añade el nuevo obj que hayamos elegido anteriormente
		gameContainer.clear(getWidth(), getPositionPc() + getVisibility() - 1, getPositionPc() + getVisibility());
		GameObjectGenerator.forceAdvanceObject(this, id, getPositionPc() + getVisibility() - 1);
	}
	
	public void explosion(int x, int y) {
		//elimina todo los obj que este alrededor de la granada(invluido el) excepto las monedas.
		for (int i = x - 1; i <= x + 1; i++) {

			for (int j = y - 1; j <= y + 1; j++) {
				
				if (this.getObjectOnPos(i, j) != null ) { 
					if(this.getObjectOnPos(i, j).receiveExplosion()) {//todo los obj excepto las monedas
						removes(getObjectOnPos(i, j));
					} 
				}
			}
		}
	}

	public boolean setExit() { // salir del juego

			System.out.println("Exit succesfull");
			System.exit(0);
		
			this.exit = true;
		return true;
	}
	
	public boolean isFinished() {//si se ha terminado el juego

		boolean ok = false;
		if (this.win() || this.dead()) {
			ok = true;
		}
		return ok;
	}

	public int distanceToGoal() {//devuelve la distancia de la meta
		int distance =0;
		
		distance = getLength() - getPositionPc();
		return distance;
	}
	

	public void execute(InstantAction action) throws CommandExcuteException {//realiza la accion
		cycle++;
		action.execute(this);

	}
	
	public void toggleTest() {// entrar al game sin el time
		test = true;

	}


	public int getPositionPc() { // devuelve la columna que esta el jugador
		return (player.getPosC());
	}

	public int getPositionPf() {//devuelve la fila del jugador
		return (player.getPosF());
	}

	public String toString() {//devuelve los simbolos del tablero, obj, etc
		return printer.toString();
	}

	public int getVisibility() { // devuelve la visibilidad dependiendo del nivel
		return level.getVisibility();
	}

	public int getLength() { // devuelve la longitud de la carretera
		return level.getLength();
	}

	public int getWidth() { // devuelve la anchura de la carretera
		return level.getWidth();
	}

	public String getPlayerSymbol() {
		return player.toString();	
		}
	public double getObsFrenc() {// devuelve la frecuencia de obs dependiendo del nivel
		return level.getObstacleFrequency();
	}

	public double getCoinFrenc() { // devuelve la frecuencia de coin dependiendo del nivel
		return level.getCoinFrequency();
	}

	public boolean up() { // realiza el momiento hacia arriba

		return player.up();
	}

	public boolean down() { // realiza el movimiento hacia abajo
		return player.down(level);
	}

	
	public int playerCoins() {// devuelve el monedero del jugador

		return player.getNumCoin();
	}

	public int getCycle() {
		// TODO Auto-generated method stub
		return cycle;
	}

	public String getPlayerSymbolString () {
		return player.toString();
	}
	public boolean isTestMode() {
		// TODO Auto-generated method stub
		return test;
	}

	public long elapsedTime() {// devuelve el tiempo
		
		return (nowtime - currenttime);
	}


	public boolean hasArrived() {//nos confirma si ha llegado 
		return (this.getPositionPc() == this.getLength() -1);
	}

	public boolean isUserExit() {// si quiere salir
		// TODO Auto-generated method stub
		return exit;
	}

	public Level getLevel() {//el nivel
		// TODO Auto-generated method stub
		return level;
	}


	public Collider getObjectOnPos(int x, int y) {//devuelve el obj

		return gameContainer.getCollliderPosition(x, y);
	}
	

	public void forceAddObject(GameObject o) {//añadoir el objeto a la fuerza (cheatcommand)
		gameContainer.add(o);

	}


	public void addGrenade(int x, int y) throws CommandExcuteException {//metodo para añadir la granadad
		
		if(x >= 0 && x < 4) {
			if ( y >= this.getPositionPc() && y < this.getPositionPc() + this.getVisibility() ) {
				GameObjectGenerator.generateGrenade(this, x, y);
			}
		}
		
		else {
			
			throw new InvalidPositionException("Invalid position");
			}
		}
	

	public void setPlayerCoin(int coin) {//asignar una cantidad de moneda, ya sea negativa o positiva

		
		player.addCoins(coin);
		
	}

	
	public boolean isAlive ( int x , int y ) {//si esta vivo
		return gameContainer.isAlive(x, y);
	}


	public boolean isNewRecord() {//devuelve true para el nuevo reord
		// TODO Auto-generated method stub
		return true;
	}
	
	public String getSerializeInfoString (int x, int y ) {
		String s ="";
		s = gameContainer.getSerializeStringInfoString(x, y);
		return s;
	}
	
	public String getAllInfoString () {
		String s = "";
		
		s = serializer.getInfo();
		
		return s;
	}
	
	public boolean buy (int cost) {
		boolean ok = false;
		
		if ( cost <= this.playerCoins() ) {
			player.addCoins(-cost);//restamos el coste al monedero del jugado
			ok = true;
		}
		
		return ok;
	}
	
	
	public long getRecord () {
		
		return _record.getRecord(level);
	}
}