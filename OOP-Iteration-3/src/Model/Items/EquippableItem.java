package Model.Items;

import Model.Entity.Ability.Ability;

public abstract class EquippableItem extends TakeableItem {

    public EquippableItem(Ability ability, String name) {
        super(ability, name);
    }
}
