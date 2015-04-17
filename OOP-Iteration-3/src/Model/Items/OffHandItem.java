package Model.Items;

import Model.Entity.Ability.Ability;

public abstract class OffHandItem extends EquippableItem{
    public OffHandItem(Ability ability, String name) {
        super(ability, name);
    }
}
