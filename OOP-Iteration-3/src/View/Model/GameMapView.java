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
import View.View;

public class GameMapView extends ModelView {
	
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
		System.out.println("why only once");
		int hexagon_size = 100;
		Point origin = new Point(View.WIDTH / 2, View.HEIGHT / 2);
		
		HexagonalLocation center = avatar.getLocation();
		int grid_radius = View.WIDTH / hexagon_size;
		ArrayList<HexagonalTile> hex_tiles = gMap.getTilesSurroundingAvatar(grid_radius);
		
		for (HexagonalTile hex_tile : hex_tiles) {
			hex_tile.render(g, origin, center);
			
		}
		
	}
	
	public void renderStatus(Graphics g){
//		float healthScale = avatar.getStatistics(). / maxHealth;
//	    g.setColor(healthBarColor);
//	    g.fillRect(healthBarX, healthBarY, healthBarWidth * healthScale, healthBarHeight);
	}

}
