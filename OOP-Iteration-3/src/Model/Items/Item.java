package Model.Items;


import Model.Entity.Ability.Ability;
import Model.SaveSystem.Savable;
import Model.SaveSystem.Saver;
import View.Model.MapObjectView;


public abstract class Item implements MapObject, Savable{

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

    public String getName(){
        return name;
    }

    public MapObjectView getMapObjectView(){
        return mov;
    }

    public String getDescription(){
        return description;
    }
    
    public void save(Saver saver)
    {
    	saver.save(this);
    }
    
    public String toString()
    {
    	StringBuilder builder = new StringBuilder();
    	builder.append(name);

    	//return "";
        return name;
    }

}