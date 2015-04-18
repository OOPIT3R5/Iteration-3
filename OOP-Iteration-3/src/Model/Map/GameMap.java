package Model.Map;

import Model.Map.Grid.HexagonalGrid;
import View.GameView;

public class GameMap extends HexagonalGrid{
	
	private GameView view = new GameView();

	public GameMap(int width, int height) {
		super(width, height);
	}

	public GameView getView() {
		return view;
	}
	
}
