package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.EquippableItemVisitor;

public class SneakWeaponItem extends WeaponItem{
    SneakWeaponItem(AttackSpeed attackspeed, int statchange, Ability ability, String name) {
        super(AttackSpeed.FAST, statchange, ability, name);
    }

    @Override
    public boolean isTwoHanded() {
        return true; //Assuming all sneak weapons are 2-handed
    }

    @Override
    public void accept(EquippableItemVisitor eiv) {
        eiv.visit(this);
    }
}
