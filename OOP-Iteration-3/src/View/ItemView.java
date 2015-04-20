package View;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import Model.Map.Direction;
import Model.Map.HexagonalLocation;
import View.Model.MapObjectView;

public class ItemView {
	MapObjectView spriteSheet;
	BufferedImage sprite;
	
	public void render(Graphics g, HexagonalLocation avatar_location, Direction directionFacing, HexagonalLocation currentLocation) throws IOException{
		Point origin = new Point(View.WIDTH / 2, View.HEIGHT / 2);
		
		int x = (int)(origin.getX() + 3 / 2.0 * 100 * (currentLocation.getU() - avatar_location.getU()));
		int y = (int)(origin.getY() + Math.sqrt(3) * 100 * ((currentLocation.getV() - avatar_location.getV()) + (currentLocation.getU() - avatar_location.getU()) / 2.0));
		
		
	
		g.translate(-(x+3), -(y-5));

		switch(directionFacing){
		
		case NORTH:
			g.drawImage(MapObjectView.getSpriteFromPokemon(6, 3), x, y, null);
			break;
		case SOUTH:
			
			g.drawImage(MapObjectView.getSpriteFromPokemon(6, 0), x, y, null);

			break;
		case NORTHEAST:
			
			g.drawImage(MapObjectView.getSpriteFromPokemon(6, 2), x, y, null);

			break;
		case NORTHWEST:
			
			g.drawImage(MapObjectView.getSpriteFromPokemon(6, 1), x, y, null);

			break;
		case SOUTHWEST:
			
			g.drawImage(MapObjectView.getSpriteFromPokemon(6, 1), x, y, null);

			break;
		case SOUTHEAST:
			
			g.drawImage(MapObjectView.getSpriteFromPokemon(6, 2), x, y, null);
			break;
		default:
			
			g.drawImage(MapObjectView.getSpriteFromPokemon(6, 1), x, y, null);
			
		}
		
		
		
		}
}
