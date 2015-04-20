package Model.Items;

import java.awt.Graphics;
import java.util.Observable;

import Model.Entity.Entity;
import Model.Map.HexagonalLocation;
import Model.Map.Location;
import View.Model.MapObjectView;

public abstract class MapObject extends Observable {
	
    public abstract MapObjectView getMapObjectView();

    abstract public String getName();

    public abstract boolean isPassable();

	public abstract void onTouch(Entity entity);
	
    protected abstract void render(Graphics g, HexagonalLocation center, Location location);
    
}