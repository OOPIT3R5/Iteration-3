package Model.Items;

import Model.Entity.Ability.Ability;
import View.MapObjectView;

public class UsableItem extends TakeableItem{
    public UsableItem(Ability ability, String name, MapObjectView mov) {
        super(ability, name, mov);
    }

    @Override
    public boolean isPassable() {
        return true;
    }
}
