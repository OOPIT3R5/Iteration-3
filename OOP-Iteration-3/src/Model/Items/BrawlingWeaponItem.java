package Model.Items;

import Model.Entity.Ability.Ability;

public class BrawlingWeaponItem extends SmasherWeaponItem {
    BrawlingWeaponItem(int statchange, Ability ability, String name) {
        super(AttackSpeed.FAST, statchange, ability, name);
    }

    @Override
    public boolean isTwoHanded() {
        return true;//Brawling with BOTH HANDS BABY
    }
}
