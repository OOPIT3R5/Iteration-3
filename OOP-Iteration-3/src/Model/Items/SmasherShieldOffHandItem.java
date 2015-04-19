package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.TakeableItemVisitor;
import View.MapObjectView;

public class SmasherShieldOffHandItem extends OffHandItem{
    public SmasherShieldOffHandItem(int statchange, Ability ability, String name, MapObjectView mov) {
        super(statchange, ability, name, mov);
    }

    public void accept(TakeableItemVisitor eiv){
        eiv.visit(this);
    }
}
