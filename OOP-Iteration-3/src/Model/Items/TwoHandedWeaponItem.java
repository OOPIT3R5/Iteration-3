package Model.Items;

import Model.Entity.Ability.Ability;

public class TwoHandedWeaponItem extends SmasherWeaponItem {

    private String name;

    TwoHandedWeaponItem(AttackSpeed attackspeed, Ability ability, String name) {
        super(attackspeed, ability, name);
    }

    @Override
    public boolean isTwoHanded() {
        return true; //TWO-handeed weapon is two-handed. kk
    }
}
