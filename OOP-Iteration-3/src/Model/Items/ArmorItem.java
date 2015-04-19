package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.TakeableItemVisitor;
import View.Model.MapObjectView;

public class ArmorItem extends EquippableItem{
    public ArmorItem(int statchange, String name, MapObjectView mov) {
        super(statchange, name, mov);
    }

    public void accept(TakeableItemVisitor eiv){
        eiv.visit(this);
    }
}
