package Controller;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.JFrame;

import Main.Game;
import Main.KeySet;
import Model.Entity.Avatar;
import Model.Entity.Summoner;
import Model.Menu.MainMenu;
import Model.SaveSystem.GameLoader;
import View.ModelView;



public class MainMenuController extends Controller {
	public class DownAction implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeySet.getKey("NORTH")){
				mm.MoveDown();
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
			if(key == KeySet.getKey("SOUTH")){
				mm.MoveUp();
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
	};
	public class Update implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeySet.getKey("ENTER")){
				String state = mm.getState();
				if(state.equals("new")){ //Is there a way around this?
					setNext(CharacterCreationController.getInstance());
					
				}
				else if(state.equals("options")){
					setNext(ConfigController.getInstance());
				}
				else if(state.equals("load")){
					setNext(GameController.getInstance());
					
					Avatar avatar = new Avatar();
					new Summoner(avatar); // delete later
					Game game = new Game(avatar);
					//DefaultGame dg = new DefaultGame(game.getGameMap());
					//game.erase(); // might not actually need to call this
					File loadFile = new File("save.csv");
					GameLoader loader = new GameLoader(loadFile, avatar);
					GameController.setGame(game);
					
				}
				else{
					setNext(null);
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
	public static MainMenuController getInstance(){
		
		if(instance == null){
			
			instance = new MainMenuController();
		}
		
			return instance;
		
	}
	MainMenu mm;
	private static MainMenuController instance = null;
	
	KeyListener up = new UpAction();
	KeyListener down = new DownAction();
	
	KeyListener enter = new Update();
	KeyListener render = new Render();
	private MainMenuController(){
		mm = new MainMenu();
	}
	
	@Override
	public void deRegister(JFrame f){
		f.removeKeyListener(up);
		f.removeKeyListener(down);
		f.removeKeyListener(enter);
		f.removeKeyListener(render);
	}
	@Override
	public ModelView getView(){
		return mm.getView();
	}
	@Override
	public void register(JFrame f){
		f.addKeyListener(up);
		f.addKeyListener(down);
		f.addKeyListener(enter);
		f.addKeyListener(render);
	}
}
