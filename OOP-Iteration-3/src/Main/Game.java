package Main;

import Model.Entity.Avatar;
import Model.Map.GameMap;
import View.GameView;

public class Game {
	
	GameView gameView;
	GameMap gameMap;
	Avatar avatar;
	
	public Game(GameMap gameMap, Avatar avatar){
		
		this.gameMap = gameMap;
		this.avatar = avatar;
		gameView = new GameView(gameMap, avatar);
	}
	
	
	public GameView getView(){
		
		return gameView;
	}


}
