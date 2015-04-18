package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.EquippableItemVisitor;

public class AccessoryItem extends EquippableItem {
    public AccessoryItem(int statchange, Ability ability, String name) {
        super(statchange, ability, name);
    }

    public void accept(EquippableItemVisitor eiv){
        eiv.visit(this);
    }
}
