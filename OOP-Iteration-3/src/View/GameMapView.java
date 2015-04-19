package View;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;

import Model.Entity.Avatar;
import Model.Map.GameMap;
import Model.Map.HexagonalLocation;
import Model.Map.Grid.Tile.HexagonalTile;
import Model.Map.View.FlatHexagon;

public class GameMapView extends ModelView{
	
	GameMap gMap;
	Avatar avatar;
	public GameMapView(GameMap map)
	{
		this.gMap = map;
		avatar = gMap.getAvatar();
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
		

		ArrayList<HexagonalLocation> hex_locations = gMap.getHexTiles();
		for (HexagonalLocation hl : hex_locations) {
			HexagonalTile hexTile = (HexagonalTile)gMap.getTile(hl);
			//System.out.println(hexTile.getLocation().getU());
			if(hexTile != null)
				hexTile.render(g);
			else
				System.out.println(hl.getU() + " , " + hl.getV());
			// Just outlines for now
			/*
			new FlatHexagon(new Point(
					(int)(origin.getX() + 3 / 2.0 * hexagon_size * h.getU()), 
					(int)(origin.getY() + Math.sqrt(3) * hexagon_size * ((h.getV() - center.getV()) + (h.getU() - center.getU()) / 2.0))),
					hexagon_size, false).draw(g); */
		}
		
	}

}
