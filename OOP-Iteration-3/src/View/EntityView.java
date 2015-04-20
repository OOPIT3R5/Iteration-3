package View;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JProgressBar;

import Model.Map.Direction;
import Model.Map.HexagonalLocation;
import View.Model.MapObjectView;

public class EntityView {
	public static Image getSpriteFromAvatar(int col, int row) throws IOException {
	        return ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/entity_sprites.png")).getSubimage(32*col,32*row,32,32).getScaledInstance(70, 70, Image.SCALE_DEFAULT);
	    }
	MapObjectView spriteSheet;
	  BufferedImage sprite;

	public void render(Graphics g, HexagonalLocation avatar_location, Direction directionFacing, HexagonalLocation currentLocation, int hp, int mhp  ) throws IOException{
		Point origin = new Point(View.WIDTH / 2, View.HEIGHT / 2);
		
		int x = (int)(origin.getX() + 3 / 2.0 * 100 * (currentLocation.getU() - avatar_location.getU()));
		int y = (int)(origin.getY() + Math.sqrt(3) * 100 * ((currentLocation.getV() - avatar_location.getV()) + (currentLocation.getU() - avatar_location.getU()) / 2.0));
		
		JProgressBar health = new JProgressBar(0, mhp);
		health.setForeground(Color.RED);
		health.setValue(hp);
		health.setBounds(0, 0, 25, 5);
		g.translate(x+3, y-5);
		health.paint(g);
		g.translate(-(x+3), -(y-5));
		
			switch (directionFacing) {
			
			case NORTH:
				g.drawImage(getSpriteFromAvatar(6, 3), x, y, null);
				break;
			case SOUTH:
				
				g.drawImage(getSpriteFromAvatar(6, 0), x, y, null);
	
				break;
			case NORTHEAST:
				
				g.drawImage(getSpriteFromAvatar(6, 2), x, y, null);
	
				break;
			case NORTHWEST:
				
				g.drawImage(getSpriteFromAvatar(6, 1), x, y, null);
	
				break;
			case SOUTHWEST:
				
				g.drawImage(getSpriteFromAvatar(6, 1), x, y, null);
	
				break;
			case SOUTHEAST:
				
				g.drawImage(getSpriteFromAvatar(6, 2), x, y, null);
				break;
			default:
				
				g.drawImage(getSpriteFromAvatar(6, 1), x, y, null);
				
			}
		}
		
		
		
		
	}


