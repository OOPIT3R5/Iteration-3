package Model.Map;

import java.util.ArrayList;

import Model.Map.Grid.HexagonalGrid;
import View.GameMapView;
import View.ModelView;


public class GameMap extends HexagonalGrid {
	
	
	GameMapView mapView;
	
	public ArrayList<HexagonalLocation> getLine(Location loc)
	{
		return null;
		//TODO modify location interface
		
		
	
	}

	public GameMap(int width, int height) {
		super(width, height);
		 mapView = new GameMapView();
	}

	public ModelView getView() {
		// TODO Auto-generated method stub
		return mapView;
	}

	
}
