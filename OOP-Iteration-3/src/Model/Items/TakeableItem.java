package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.Entity;
import Model.Entity.TakeableItemVisitor;
import View.MapObjectView;

public abstract class TakeableItem extends Item{

    public TakeableItem(Ability ability, String name, MapObjectView mov) {
        super(ability, name, mov);
    }

    @Override
    public boolean isPassable(){
        return true;
    }

    @Override
    public void onTouch(Entity entity){
        entity.addToInventory(this); //Add to inventory.
    }

    public abstract void accept(TakeableItemVisitor eiv);
}
