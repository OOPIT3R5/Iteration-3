package View;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Observable;

import Model.Map.HexagonalLocation;
import Model.Map.Grid.Tile.HexagonalTile;
import Model.Map.View.FlatHexagon;

public class HexTileView extends ModelView{

	HexagonalTile tile;
	
	public HexTileView(HexagonalTile tile)
	{
		this.tile = tile;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(View view) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		//g.drawOval(tile.getLocation().getU() * View.WIDTH / 100, tile.getLocation().getV() * View.HEIGHT / 100, View.WIDTH / 200,
				//View.HEIGHT/200);
		FlatHexagon fh = new FlatHexagon(new Point(tile.getLocation().getU() * View.WIDTH/100 ,tile.getLocation().getV() * View.HEIGHT/100), 10, true);
		fh.draw(g);
		
	}

}
