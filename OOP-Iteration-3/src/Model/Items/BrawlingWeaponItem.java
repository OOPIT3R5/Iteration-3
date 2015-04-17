package Model.Items;

import Model.Entity.Ability.Ability;

public class BrawlingWeaponItem extends SmasherWeaponItem {
    BrawlingWeaponItem(AttackSpeed attackspeed, Ability ability, String name) {
        super(attackspeed, ability, name);
    }

    @Override
    public boolean isTwoHanded() {
        return true;//Brawling with BOTH HANDS BABY
    }
}
