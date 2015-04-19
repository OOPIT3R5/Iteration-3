package Model.Map;

import java.util.ArrayList;

import Model.Map.Grid.HexagonalGrid;
import View.GameView;
import View.ModelView;


public class GameMap extends HexagonalGrid {
	
	
	GameView mapView;
	
	public ArrayList<HexagonalLocation> getLine(Location loc)
	{
		return null;
		//TODO modify location interface
		
		
	
	}

	public GameMap(int width, int height) {
		super(width, height);
		 mapView = new GameView();
	}

	public ModelView getView() {
		// TODO Auto-generated method stub
		return mapView;
	}

	
	
}
