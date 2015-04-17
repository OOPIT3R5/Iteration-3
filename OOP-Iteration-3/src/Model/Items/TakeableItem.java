package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.Entity;

public abstract class TakeableItem extends Item{

    public TakeableItem(Ability ability, String name) {
        super(ability, name);
    }

    @Override
    public boolean isPassable(){
        return true;
    }

    @Override
    public void onTouch(Entity entity){
        //entity.addtoinventory(this);
    }

    @Override
    public void execute(Entity entity){
        //entity.execute(this.getAbility());
    }
}
