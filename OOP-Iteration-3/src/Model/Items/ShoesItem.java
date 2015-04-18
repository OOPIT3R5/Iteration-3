package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.EquippableItemVisitor;
import View.MapObjectView;

public class ShoesItem extends EquippableItem {
    public ShoesItem(int statchange, Ability ability, String name, MapObjectView mov) {
        super(statchange, ability, name, mov);
    }

    @Override
    public void accept(EquippableItemVisitor eiv) {
        eiv.visit(this);
    }
}
