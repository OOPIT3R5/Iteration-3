package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.Entity;

public class OneShotItem extends Item {

    public OneShotItem(Ability ability, String name) {
        super(ability, name);
    }

    @Override
    public boolean isPassable() {
        return true;
    }

    @Override
    public void onTouch(Entity entity) {
        execute(entity);
    }

    @Override
    public void execute(Entity entity) {

    }
}
