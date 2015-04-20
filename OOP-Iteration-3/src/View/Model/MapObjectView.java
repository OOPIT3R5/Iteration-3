package View.Model;

import javax.imageio.ImageIO;

import Model.Map.HexagonalLocation;
import Model.Map.Location;
import View.View;

import java.awt.Graphics;
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

    public static BufferedImage getSpriteFromAvatar(int col, int row) throws IOException {
        return ImageIO.read(new File(System.getProperty("user.dir") + "/Assets/entity_sprites.png")).getSubimage(32*col,32*row,32,32);
    }

	public void render(Graphics g, HexagonalLocation center, HexagonalLocation location) {
		Point origin = new Point(View.WIDTH / 2, View.HEIGHT / 2);
		
		int x = (int)(origin.getX() + 3 / 2.0 * 100 * (location.getU() - center.getU()));
		int y = (int)(origin.getY() + Math.sqrt(3) * 100 * ((location.getU() - center.getU() + (location.getU() - center.getU()) / 2.0)));
		
		try {
			g.drawImage(MapObjectView.getSpriteFromPokemon(2 ,  2), x, y, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
