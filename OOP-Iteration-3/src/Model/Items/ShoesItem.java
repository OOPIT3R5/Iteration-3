package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.EquippableItemVisitor;

public class ShoesItem extends EquippableItem {
    public ShoesItem(int statchange, Ability ability, String name) {
        super(statchange, ability, name);
    }

    @Override
    public void accept(EquippableItemVisitor eiv) {
        eiv.visit(this);
    }
}
