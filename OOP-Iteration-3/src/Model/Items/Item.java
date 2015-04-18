package Model.Items;


import Model.Entity.Ability.Ability;
import Model.Entity.Entity;
import Model.Entity.Statistic;
import Model.Entity.StatisticContainer;

public abstract class Item implements MapObject{

    private Ability ability;                //Ability.
    private String name;                    //Name of object.

    public Item(Ability ability, String name) {
        this.ability = ability;
        this.name = name;
    }


    public Ability getAbility() {
        return ability;
    }

    public String getName(){
        return name;
    }

    public abstract void execute(Entity entity);
}
