package Model.Items;

import Model.Entity.Ability.Ability;

public abstract class OffHandItem extends EquippableItem{
    public OffHandItem(int statchange, Ability ability, String name) {
        super(statchange, ability, name);
    }
}
