package es.ucm.tp1.supercars.logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.exceptions.CommandExcuteException;
import es.ucm.tp1.supercars.exceptions.InputOutputRecordException;

public class Record {

	private static final String FILERECORD = "record.txt";
	
	private String[] level = {"TEST", "EASY", "HARD", "ADVANCED"};
	
	   private static File filename=new File(FILERECORD);
	   
	private long r_TEST;
	
	private long r_EASY;
	
	private long r_HARD;
	
	private long r_ADVANCED;
	
  	private Level actLevel;
	
	private Game game;
	private static final long Max_record = 999999999;
	
	public Record (Game game) throws IOException, CommandExcuteException {
		
		this.game = game;
		actLevel = game.getLevel();
		recordFile();
		this.cargar();
		
	}
	
	
	 public static void recordFile() throws CommandExcuteException // comprueba si existe el documento record.txt
	    {
	        if(!filename.exists()) {
	            throw new InputOutputRecordException("[Error]: faild to find the file record.txt.");
	        }
	    }
		
	
	public long getRecord (Level level) { // devuelve el record segun el nivel actual
		
		long r = 0;
		
		switch (level) {
		case TEST:
			r =  r_TEST;
			break;
		case EASY:
			r = r_EASY;
			break;
		case HARD:
			r= r_HARD;
			break;
		case ADVANCED:
			r= r_ADVANCED;
			break;
		default:
			break;
		}
		
		return r;
	}
	

    public void cargar () throws IOException { // carga los records
    	boolean ok=false;
    	BufferedReader inFileBufferedReader = null;
    	
    	try {
    	for(int j=0;j<level.length;j++)
        {
            ok=false;
            String tokens[];
            inFileBufferedReader = new BufferedReader( new FileReader(FILERECORD));
            String line= inFileBufferedReader.readLine();

            while(line!=null&&!ok)
            {
            	tokens=line.split(":");
            	if(tokens[0].equalsIgnoreCase(level[j]))
            	{
                ok=true;
                saveRecord(Level.valueOfIgnoreCase(level[j]),Integer.valueOf(tokens[1]));
            }
            line=inFileBufferedReader.readLine();
        }
        if(!ok){
            saveNull(Level.valueOfIgnoreCase(level[j]),Max_record);
            saveRecord(Level.valueOfIgnoreCase(level[j]),Max_record);
        }
        }
    	
    	
        }catch (IOException e) {
            throw e;
        }
    }
    
    private void saveRecord(Level level,long record) // guarda el record del fichero dentro de las variables para posteriormente sobreescribirla
    {

    	switch (level) {
		case TEST:
			r_TEST = record;
			break;
		case EASY:
			r_EASY = record;
			break;
		case HARD:
			r_HARD = record;
			break;
		case ADVANCED:
			r_ADVANCED = record;
			break;
		default:
			break;
		}
    }
    
    private void saveNull (Level level, long max) throws IOException { // crea un nuevo record en caso de que si el txt no tiene record
    	BufferedWriter outFileBufferedWriter = null;
    	
    	try {
    		outFileBufferedWriter = new BufferedWriter( new FileWriter(FILERECORD, true));
    		outFileBufferedWriter.newLine();
    		outFileBufferedWriter.append(level+":"+max);
    		outFileBufferedWriter.close();
    	}
    	
    	catch (IOException e) {
    		throw e;
    	}
    }

    private void guardar () throws IOException { // guarda records
    	BufferedWriter outFileBufferedWriter = null;
    	try {
    		outFileBufferedWriter = new BufferedWriter( new FileWriter(FILERECORD, false));
    		for(int i=0;i<level.length;i++)
            {
    			outFileBufferedWriter.append(level[i]+":"+getRecord(Level.valueOfIgnoreCase(level[i]))+"\n");
            }
    		outFileBufferedWriter.close();
    	}
    	
    	catch (IOException e) {
    		throw e;
    		
    	}
    	
    }
    
    public boolean newRecord () { // comprueba si hubo un nuevo record , lo compara con el actual y lo guarda
    	
    	boolean ok = false;
    	
    	if ( game.elapsedTime() < getRecord(actLevel)) {
    		ok = true;
    		
    		saveRecord(actLevel, game.elapsedTime());
    		
    		try {
    			
    			guardar();
    		}
    		
    		catch (IOException e) {
    			System.out.println(e.getMessage());
    		}
    	}
    	return ok;
    }
}
