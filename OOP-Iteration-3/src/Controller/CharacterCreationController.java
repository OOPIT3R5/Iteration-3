package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

import Main.Game;
import Main.KeySet;
import Main.RunGame;
import Model.Entity.Avatar;
import Model.Entity.Smasher;
import Model.Entity.Sneak;
import Model.Entity.Summoner;
import Model.Menu.CharacterCreation;
import View.ModelView;

public class CharacterCreationController extends Controller  {
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
	public static CharacterCreationController getInstance(){
		
		if(instance == null){
			 
			instance = new CharacterCreationController();
		}
		return instance;
	}
	public void register(JFrame f){
		f.addKeyListener(enter);
		f.addKeyListener(down);
		f.addKeyListener(up);
		f.addKeyListener(render);
	}
	
	public void deRegister(JFrame f){
		f.removeKeyListener(enter);
		f.removeKeyListener(down);
		f.removeKeyListener(up);
		f.removeKeyListener(render);
	}

	@Override
	public ModelView getView() {
		// TODO Auto-generated method stub
		return cm.getView();
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
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
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
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
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
					GameController.setGame(game); //set the game to the controller
					

				}
				else if(state.equals("Smasher")){
					setNext(GameController.getInstance());
					new Smasher(avatar);
					Game game = new Game(avatar);
					GameController.setGame(game);
				}
				else if(state.equals("Sneak")){
					setNext(GameController.getInstance());
					new Sneak(avatar);
					Game game = new Game(avatar);
					GameController.setGame(game);
				}
				else{
					setNext(MainMenuController.getInstance());
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

}
