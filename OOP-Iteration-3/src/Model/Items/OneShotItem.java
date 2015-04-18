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


    //TODO: Figure out the situation of triggering a OneShotItem.
    @Override
    public void onTouch(Entity entity) {
        getAbility().execute();
    }
}
