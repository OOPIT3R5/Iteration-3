package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.TakeableItemVisitor;
import View.MapObjectView;

public class SneakWeaponItem extends WeaponItem{
    SneakWeaponItem(AttackSpeed attackspeed, int statchange, Ability ability, String name, MapObjectView mov) {
        super(AttackSpeed.FAST, statchange, ability, name, mov);
    }

    @Override
    public boolean isTwoHanded() {
        return true; //Assuming all sneak weapons are 2-handed
    }

    @Override
    public void accept(TakeableItemVisitor eiv) {
        eiv.visit(this);
    }
}
