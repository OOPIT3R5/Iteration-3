package Model.Items;

import Model.Entity.Ability.Ability;

public class OneHandedWeaponItem extends SmasherWeaponItem {

    OneHandedWeaponItem(int statchange, Ability ability, String name) {
        super(AttackSpeed.MEDIUM, statchange, ability, name);
    }

    @Override
    public boolean isTwoHanded() {
        return false;//One handed sword, duh
    }
}
