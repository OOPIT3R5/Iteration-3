package View.Model;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Observable;

import Main.Game;
import Main.RunGame;
import Model.Entity.Avatar;
import Model.Map.GameMap;
import Model.Map.HexagonalLocation;
import Model.Map.Grid.HexagonalGrid;
import Model.Map.Grid.Tile.HexagonalTile;
import Model.Terrain.Grass;
import Model.Terrain.Mountain;
import Model.Terrain.Water;
import View.View;

public class GameView extends ModelView {
	Game game;
	GameMap gameMap;
	Avatar avatar;
	
	public GameView(GameMap gameMap, Avatar avatar) {
		this.gameMap = gameMap;
		this.avatar = avatar;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
	}

	@Override
	public void accept(View view) {
		view.visit(this);
	}

	@Override
	public void render(Graphics g) {
		/*
		g.drawOval(50, 50,50, 50);
		gameMap = new GameMap(100, 100);
		gameMap.fill(new HexagonalTile(new Grass()));
		//System.out.println(gg.toString());

		gameMap.add(1, 1, new HexagonalTile(new Water()));
		gameMap.add(5, 5, new HexagonalTile(new Mountain()));
		
		gameMap.drawRectangleWithCoords(g, new Point(0, 0), new HexagonalLocation(0, 0), 100, 100, 20);
		
		*/
		gameMap.render(g, avatar);
	}


}
