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
		renderStatus(g);
	}
	
	public void renderStatus(Graphics g){
		int hp = avatar.getStatistics().getLife();
		int mhp = avatar.getStatistics().getMaxLife();
		float healthScale = hp/mhp;
	    g.setColor(Color.WHITE);
	    g.fillRoundRect(0, 0, 200, 22, 5, 5);
	    g.setColor(Color.RED);
	    g.fillRect(0, 0, (int) (200 * healthScale), 22);
	    
	    float manaScale = avatar.getStatistics().getMana() / avatar.getStatistics().getMaxMana();
	    g.setColor(Color.WHITE);
	    g.fillRoundRect(300, 0, 200, 22, 5, 5);
	    g.setColor(Color.BLUE);
	    g.fillRect(300, 0, (int) (200 * manaScale), 22);
	}

}
