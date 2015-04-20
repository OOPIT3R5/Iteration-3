package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import Main.Game;
import Main.KeySet;
import Model.Entity.Avatar;
import Model.Entity.Entity;
import Model.Entity.Ability.Ability;
import Model.Map.HexagonalLocation;
import Model.SaveSystem.CSVSaver;
import Model.SaveSystem.SaveDriver;
import View.GameView;
import View.ModelView;

public class GameController extends Controller implements Observer {
	public class AbilityListener implements KeyListener {
		
		String s = "";
		String key = "";
		public AbilityListener(String s,  String key){
			this.s = s;
			this.key = key;
		}
		@Override
		public void keyPressed(KeyEvent k) {
			if(k.getKeyCode() == KeySet.getKey(key)){
				avatar.ability(s);
				System.out.println(s);
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	public class BacktoMainMenu implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeySet.getKey("BACK")){
				setNext(MainMenuController.getInstance());		
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
	}

	public class Dialogue implements KeyListener {
		
			
			protected boolean checkDistance(HexagonalLocation a, HexagonalLocation b, int min, int max){
			    	if(Math.abs(a.getV() - b.getV()) < min && Math.abs(a.getU() - b.getU()) < min){
			    		return false;
			    	}
			    	else if(Math.abs(a.getV() - b.getV()) <= max && Math.abs(a.getU() - b.getU()) <= max){
			    		return true;
			    	}
			    	return false;
			    }
			 @Override
			public void keyPressed(KeyEvent k) {
				if(k.getKeyCode() == KeyEvent.VK_C){
					System.out.println("Dialogue");
					ArrayList<Entity> entities = avatar.getGamemap().getAllNPCS();
					for(int i=0; i<entities.size(); i++){
						if(checkDistance(avatar.getLocation(),entities.get(i).getLocation(),1,2)){
							String s = entities.get(i).dialogue();
							System.out.println(s);
							GameView.writeToLog(s);
							
						}
					}
				}
				
			}
	
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
	
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		}
	public class InventoryListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent k) {
			int key = k.getKeyCode();
			if(key == KeySet.getKey("INVENTORY")){
				setNext(InventoryController.getInstance(avatar));
				
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
	}

	public class MoveNorth implements KeyListener {

		@Override
		public void keyPressed(KeyEvent k) {
			int key = k.getKeyCode();
			if(key == KeySet.getKey("NORTH") || key == KeyEvent.VK_NUMPAD8){
				avatar.moveNorth();
			//	avatar.getStatistics().changeHealth(-10);
				System.out.println(avatar.getLocation());
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	public class MoveNortheast implements KeyListener {

		@Override
		public void keyPressed(KeyEvent k) {
			int key = k.getKeyCode();
			if(key == KeySet.getKey("NORTHEAST") || key == KeyEvent.VK_NUMPAD9){
				avatar.moveNortheast();
				System.out.println(avatar.getLocation());
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	public class MoveNorthwest implements KeyListener {

		@Override
		public void keyPressed(KeyEvent k) {
			int key = k.getKeyCode();
			if(key == KeySet.getKey("NORTHWEST") || key == KeyEvent.VK_NUMPAD7){
				avatar.moveNorthwest();
				System.out.println(avatar.getLocation());
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public class MoveSouth implements KeyListener {

		@Override
		public void keyPressed(KeyEvent k) {
			int key = k.getKeyCode();
			if(key == KeySet.getKey("SOUTH") || key == KeyEvent.VK_NUMPAD5){
				avatar.moveSouth();
			//	avatar.getStatistics().useMana(5);
				System.out.println(avatar.getLocation());
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	
	 //This will be removed
	
	public class MoveSoutheast implements KeyListener {

		@Override
		public void keyPressed(KeyEvent k) {
			int key = k.getKeyCode();
			if(key == KeySet.getKey("SOUTHEAST") || key == KeyEvent.VK_NUMPAD6){
				avatar.moveSoutheast();
				System.out.println(avatar.getLocation());
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public class MoveSouthwest implements KeyListener {

		@Override
		public void keyPressed(KeyEvent k) {
			int key = k.getKeyCode();
			if(key == KeySet.getKey("SOUTHWEST") || key == KeyEvent.VK_NUMPAD4){
				avatar.moveSouthwest();
				System.out.println(avatar.getLocation());
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public class Save implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			
			
				
			}
			
		

		@Override
		public void keyReleased(KeyEvent arg0) {
			int key = arg0.getKeyCode();
			if(key == KeySet.getKey("SAVE")){
				SaveDriver saveDriver = new SaveDriver(game.getGameMap() , new CSVSaver());
		}
		}
		@Override
		public void keyTyped(KeyEvent arg0) {
		
		}
		
	}
	public class UpdateAllEntities implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			ArrayList<Entity> entities = game.getGameMap().getAllNPCS();
			for(int i=0; i<entities.size(); i++){
				entities.get(i).performAction();
				
			}
			avatar.regenMana();
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
	}

	public static GameController getInstance(){
		
		if(instance == null){
			
			instance = new GameController();
		}
		return instance;
	}

	public static void setGame(Game g){
		ArrayList<Entity> entities = g.getGameMap().getAllNPCS();
		for(int i=0; i<entities.size(); i++){
			entities.get(i).addObserver(GameController.getInstance());
		}
		game = g;
		avatar = g.getAvatar();
		avatar.setLocation(new HexagonalLocation(2,3));
		g.getGameMap().spawn(avatar,new HexagonalLocation(2,3));
		avatar.setMap(g.getGameMap());
		avatar.addObserver(GameController.getInstance());
		
	}
	
	String next = "";
	
	private static Avatar avatar;
	
	private static Game game;
	
	private static GameController instance = null;
	
	KeyListener back = new BacktoMainMenu();
	
	KeyListener inv = new InventoryListener();
	
	KeyListener render = new Render();
	ArrayList<KeyListener> listeners = new ArrayList<KeyListener>();
	
	private GameController() {
		
	}
@Override
public void deRegister(JFrame f) {
	for(KeyListener k : listeners){
		f.removeKeyListener(k);
	}
	listeners.clear();
}
	
	@Override
	public ModelView getView() {
		
		return game.getView(); 	//TBD!!!!!!!!!!!!!!!!!!!!!!
	}
	@Override
	public void register(JFrame f) {
		listeners.add(new Dialogue());
		listeners.add(new BacktoMainMenu());
		listeners.add(new InventoryListener());
		listeners.add(new Render());
		listeners.add(new MoveNorth());
		listeners.add(new MoveSouth());
		listeners.add(new MoveNortheast());
		listeners.add(new MoveNorthwest());
		listeners.add(new MoveSoutheast());
		listeners.add(new MoveSouthwest());
		listeners.add(new UpdateAllEntities());
		listeners.add(new Save());
		HashMap<String, Ability> abilities = avatar.getOccupation().getAbilities();
		int i = 1;
		String name = "ACTION" + i;
		String info = "";
		for(Entry<String, Ability> entry : abilities.entrySet()){
			listeners.add(new AbilityListener(entry.getKey(),name));
			info += entry.getKey() + " : " + KeyEvent.getKeyText(KeySet.getKey(name)) + "\n";
			name = "ACTION" + (++i);
		}
		GameView.writeToLog(info);
		for(KeyListener k : listeners){
			f.addKeyListener(k);
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		if(avatar.getStatistics().getNumLivesLeft() <= 0){
			setNext(MainMenuController.getInstance());
			avatar.deleteObservers();
		}
		else{

			avatar.awardExperience(500);
			avatar.awardGold(500);
		}
		
		
	}
	
	

}
