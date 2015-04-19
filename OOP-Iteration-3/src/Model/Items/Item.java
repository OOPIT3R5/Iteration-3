package Model.Items;


import Model.Entity.Ability.Ability;
import Model.SaveSystem.Savable;
import Model.SaveSystem.Saver;
import View.MapObjectView;

import java.awt.image.BufferedImage;

public abstract class Item implements MapObject, Savable{

    private Ability ability;                //Ability.
    private String name;                    //Name of object.
    private MapObjectView mov;               //BufferedImage.

    public Item(Ability ability, String name, MapObjectView mov) {
        this.ability = ability;
        this.name = name;
        this.mov   = mov;
    }


    public Ability getAbility() {
        return ability;
    }

    public String getName(){
        return name;
    }

    public void execute(){
        ability.execute();
    }

    public MapObjectView getMapObjectView(){
        return mov;
    }
    
    public void save(Saver saver)
    {
    	saver.save(this);
    }

}