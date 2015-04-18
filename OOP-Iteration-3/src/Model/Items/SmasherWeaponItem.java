package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.EquippableItemVisitor;

public abstract class SmasherWeaponItem extends WeaponItem{
    SmasherWeaponItem(AttackSpeed attackspeed, int statchange, Ability ability, String name) {
        super(attackspeed, statchange, ability, name);
    }

    public void accept(EquippableItemVisitor eiv){
        eiv.visit(this);
    }
}
