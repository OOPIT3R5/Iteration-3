package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.Entity;

public class InteractiveItem extends Item{

    public InteractiveItem(Ability ability, String name) {
        super(ability, name);
    }

    @Override
    public boolean isPassable() {
        return true;
    }

    @Override
    public void onTouch(Entity entity) {

    }
}
