package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import Main.Game;
import Main.KeySet;
import Model.Entity.Avatar;
import Model.Entity.Smasher;
import Model.Entity.Sneak;
import Model.Entity.Summoner;
import Model.Menu.CharacterCreation;
import Utility.DefaultGame;
import View.ModelView;

public class CharacterCreationController extends Controller  {
	public class DownAction implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeySet.getKey("NORTH")){
				cm.MoveDown();
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
	}
	public class UpAction implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeySet.getKey("SOUTH") ){
				cm.MoveUp();
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
	}
	public class Update implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeySet.getKey("ENTER")){
				String state = cm.getState();
				if(state.equals("Summoner")){ //Is there a way around this?
					setNext(GameController.getInstance()); //change controllers
					new Summoner(avatar); //create summoner
					Game game = new Game(avatar); //create new game with our new avatar
					
					DefaultGame dg = new DefaultGame(game.getGameMap());
		
					GameController.setGame(game); //set the game to the controller
					

				}
				else if(state.equals("Smasher")){
					setNext(GameController.getInstance());
					new Smasher(avatar);
					Game game = new Game(avatar);
					DefaultGame dg = new DefaultGame(game.getGameMap());
					GameController.setGame(game);
				}
				else if(state.equals("Sneak")){
					setNext(GameController.getInstance());
					new Sneak(avatar);
					Game game = new Game(avatar);
					DefaultGame dg = new DefaultGame(game.getGameMap());
					GameController.setGame(game);
				}
				else{
					setNext(MainMenuController.getInstance());
				}
				
				
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
		
	
	}
	public static CharacterCreationController getInstance(){
		
		if(instance == null){
			 
			instance = new CharacterCreationController();
		}
		return instance;
	}
	private static Avatar avatar;
	CharacterCreation cm = new CharacterCreation();
	private static CharacterCreationController instance = null;

	KeyListener up = new UpAction();
	KeyListener down = new DownAction();
	KeyListener enter = new Update();
	
	KeyListener render = new Render();

	private CharacterCreationController() {
		avatar = new Avatar();
	}
	
	@Override
	public void deRegister(JFrame f){
		f.removeKeyListener(enter);
		f.removeKeyListener(down);
		f.removeKeyListener(up);
		f.removeKeyListener(render);
	}
	@Override
	public ModelView getView() {
		return cm.getView();
	}
	
	@Override
	public void register(JFrame f){
		f.addKeyListener(enter);
		f.addKeyListener(down);
		f.addKeyListener(up);
		f.addKeyListener(render);
	}

}
