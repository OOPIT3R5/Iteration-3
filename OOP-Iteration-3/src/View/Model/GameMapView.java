package View.Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;

import Model.Entity.Avatar;
import Model.Map.GameMap;
import Model.Map.HexagonalCoordinateInterface;
import Model.Map.HexagonalLocation;
import Model.Map.Location;
import Model.Map.Grid.Tile.HexagonalTile;
import View.ModelView;
import View.View;

public class GameMapView extends ModelView {
	
	public GameMapView()
	{
	}
	
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
		
	}
	
}
