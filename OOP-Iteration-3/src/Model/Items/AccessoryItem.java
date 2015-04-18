package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.EquippableItemVisitor;
import View.MapObjectView;

public class AccessoryItem extends EquippableItem {
    public AccessoryItem(int statchange, Ability ability, String name, MapObjectView mov) {
        super(statchange, ability, name, mov);
    }

    public void accept(EquippableItemVisitor eiv){
        eiv.visit(this);
    }
}
