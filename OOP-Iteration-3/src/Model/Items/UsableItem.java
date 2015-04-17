package Model.Items;

import Model.Entity.Ability.Ability;

public class UsableItem extends TakeableItem{
    public UsableItem(Ability ability, String name) {
        super(ability, name);
    }

    @Override
    public boolean isPassable() {
        return true;
    }
}
