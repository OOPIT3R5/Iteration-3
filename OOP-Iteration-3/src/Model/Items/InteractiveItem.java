package Model.Items;

import Model.Entity.Ability.Ability;
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

    }
}
