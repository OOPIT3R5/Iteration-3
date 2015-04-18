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

    public static BufferedImage getSpriteFromPokemon(int row, int col) throws IOException {
        return ImageIO.read(new File(System.getProperty("user.dir") + "/OOP-Iteration-3/Assets/item_sprites.png")).getSubimage(25*row,25*col,24,24);
    }

    public static BufferedImage getSpriteFromFE(int row, int col) throws IOException {
        return ImageIO.read(new File(System.getProperty("user.dir") + "/OOP-Iteration-3/Assets/weapon_sprites.png")).getSubimage(25*row,25*col,24,24);
    }
}
