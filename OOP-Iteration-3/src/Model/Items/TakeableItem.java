package Model.Items;

import Model.Entity.Entity;
import Model.Entity.TakeableItemVisitor;
import View.Model.MapObjectView;

public abstract class TakeableItem extends Item{

    public TakeableItem(String name, MapObjectView mov) {
        super(name, mov);
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
    
    public String toMyString()
    {
 
    	StringBuilder builder = new StringBuilder();
    	builder.append(super.getName());
    	builder.append(",");
    	
    	return builder.toString();
    }
}
