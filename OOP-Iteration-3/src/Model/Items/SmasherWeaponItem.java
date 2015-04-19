package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.TakeableItemVisitor;
import View.MapObjectView;

public abstract class SmasherWeaponItem extends WeaponItem{
    SmasherWeaponItem(AttackSpeed attackspeed, int statchange, Ability ability, String name, MapObjectView mov) {
        super(attackspeed, statchange, ability, name, mov);
    }

    public void accept(TakeableItemVisitor eiv){
        eiv.visit(this);
    }
}
