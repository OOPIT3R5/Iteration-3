package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.Entity;
import View.Model.MapObjectView;

public class OneShotItem extends Item {

    private Ability ability;

    public OneShotItem(Ability ability, String name, MapObjectView mov) {
        super(name, mov);
        this.ability = ability;
    }

    @Override
    public boolean isPassable() {
        return true;
    }

    //TODO: Figure out the situation of triggering a OneShotItem.
    @Override
    public void onTouch(Entity entity) {
        ability.execute();
    }
}
