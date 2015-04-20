package Model.Items;

import java.awt.Graphics;
import java.awt.Point;

import Model.Entity.Entity;
import Model.Map.HexagonalLocation;
import Model.Map.Location;
import View.View;
import View.Model.MapObjectView;

public interface MapObject {
    boolean isPassable();

    void onTouch(Entity entity);

    MapObjectView getMapObjectView();

	void render(Graphics g, HexagonalLocation center, Location location);
	
    
    
}