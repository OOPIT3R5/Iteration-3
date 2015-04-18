package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.Entity;
import View.MapObjectView;

public class InteractiveItem extends Item{

    public InteractiveItem(Ability ability, String name, MapObjectView mov) {
        super(ability, name, mov);
    }

    @Override
    public boolean isPassable() {
        return true;
    }

    @Override
    public void onTouch(Entity entity) {

    }
}
