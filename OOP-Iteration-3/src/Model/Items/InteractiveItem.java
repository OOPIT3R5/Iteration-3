package Model.Items;

import Model.Entity.Ability.ItemAbility;
import Model.Entity.Entity;
import View.Model.MapObjectView;

public class InteractiveItem extends Item{

    ItemAbility ability;

    public InteractiveItem(String name, MapObjectView mov, ItemAbility ability) {
        super(name, mov);
        this.ability = ability;
    }

    @Override
    public boolean isPassable() {
        return true;
    }

    @Override
    public void onTouch(Entity entity) {
        ability.setEntity(entity);
        ability.execute();
    }
}
