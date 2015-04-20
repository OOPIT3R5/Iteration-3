package Model.Items;

import Model.Entity.Entity;
import View.Model.MapObjectView;

public class InteractiveItem extends Item{

    public InteractiveItem(String name, MapObjectView mov) {
        super(name, mov);
    }

    @Override
    public boolean isPassable() {
        return true;
    }

    @Override
    public void onTouch(Entity entity) {
        throw new RuntimeException("Need to overwrite this method to do what you want.");
    }
}
