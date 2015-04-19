package View;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Observable;

import Main.RunGame;
import Model.Map.GameMap;
import Model.Map.HexagonalLocation;
import Model.Map.Grid.HexagonalGrid;
import Model.Map.Grid.Tile.HexagonalTile;
import Model.Terrain.Grass;
import Model.Terrain.Mountain;
import Model.Terrain.Water;

public class GameView extends ModelView{
	GameMap gg;
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(View view) {
		view.visit(this);
		
	}

	@Override
	public void render(Graphics g) {
		g.drawOval(50, 50,50, 50);
		gg = new GameMap(100, 100);
		gg.fill(new HexagonalTile(new Grass()));
		//System.out.println(gg.toString());

		gg.add(1, 1, new HexagonalTile(new Water()));
		gg.add(5, 5, new HexagonalTile(new Mountain()));
		
		gg.drawRectangleWithCoords(g, new Point(0, 0), new HexagonalLocation(0, 0), 100, 100, 20);
	
	
	}


}
