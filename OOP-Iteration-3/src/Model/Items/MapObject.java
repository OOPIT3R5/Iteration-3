package Model.Items;

import java.awt.Graphics;
import java.awt.Point;

import Model.Entity.Entity;
import Model.Map.HexagonalLocation;
import Model.Map.Location;
import View.View;
import View.Model.MapObjectView;

public abstract class MapObject {
	
    abstract boolean isPassable();

    public abstract void onTouch(Entity entity);

    public abstract MapObjectView getMapObjectView();

	abstract void render(Graphics g, HexagonalLocation center, Location location);
	
    abstract public String getName();
    
}