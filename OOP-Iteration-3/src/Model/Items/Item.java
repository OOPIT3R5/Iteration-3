package Model.Items;


import java.awt.Graphics;
import java.awt.Point;

import Model.Map.HexagonalLocation;
import Model.Map.Location;
import Model.SaveSystem.Savable;
import View.View;
import View.Model.MapObjectView;


public abstract class Item extends MapObject implements Savable{

    private String name;                    //Name of object.
    private MapObjectView mov;               //BufferedImage.
    private String description = "";             //Description

    public Item(String name, MapObjectView mov) {
        this.name = name;
        this.mov   = mov;
    }

    public Item(String name, MapObjectView mov, String description){
        this.name = name;
        this.mov  = mov;
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    @Override
	public MapObjectView getMapObjectView(){
        return mov;
    }

    @Override
	public String getName(){
        return name;
    }
    
  
    
    @Override
	public void render(Graphics g, HexagonalLocation center, Location loc) {
		Point origin = new Point(View.WIDTH / 2, View.HEIGHT / 2);
		
		
	}

	@Override
	public String toString()
    {
    	StringBuilder builder = new StringBuilder();
    	builder.append(name);

    	//return "";
        return name;
    }
    
    
    
}