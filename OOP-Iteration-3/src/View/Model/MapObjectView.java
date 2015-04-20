package View.Model;

import javax.imageio.ImageIO;

import Model.Map.HexagonalLocation;
import View.View;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MapObjectView {
	
    private BufferedImage bi;

    public MapObjectView(BufferedImage bi){
        this.bi = bi;
    }

    public BufferedImage getBufferedImage(){
        return bi;
    }

    public static BufferedImage getSpriteFromPokemon(int col, int row) throws IOException {
        return ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/item_sprites.png")).getSubimage(24*col,24*row,24,24);
    }

    public static BufferedImage getSpriteFromFE(int col, int row) throws IOException {
        return ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/weapon_sprites.png")).getSubimage(24*col,24*row,24,24);
    }

  
	public void render(Graphics g, HexagonalLocation center, HexagonalLocation location) {
		Point origin = new Point(View.WIDTH / 2, View.HEIGHT / 2);
		
		int x = (int)(origin.getX() + 3 / 2.0 * 100 * (location.getU() - center.getU()));
		int y = (int)(origin.getY() + Math.sqrt(3) * 100 * ((location.getV() - center.getV() + (location.getV() - center.getV()) / 2.0)));
		
		g.drawImage(bi.getScaledInstance(75,75,Image.SCALE_DEFAULT), x, y, null);
	}
}
