package View;

import javax.imageio.ImageIO;
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
        return ImageIO.read(new File(System.getProperty("user.dir") + "/OOP-Iteration-3/Assets/item_sprites.png")).getSubimage(24*col,24*row,24,24);
    }

    public static BufferedImage getSpriteFromFE(int col, int row) throws IOException {
        return ImageIO.read(new File(System.getProperty("user.dir") + "/OOP-Iteration-3/Assets/weapon_sprites.png")).getSubimage(24*col,24*row,24,24);
    }

    public static BufferedImage getSpriteFromAvatar(int col, int row) throws IOException {
        return ImageIO.read(new File(System.getProperty("user.dir") + "/OOP-Iteration-3/Assets/weapon_sprites.png")).getSubimage(32*col,32*row,32,32);
    }
}
