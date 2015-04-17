package Model.Items;

import Model.Entity.Ability.Ability;

public abstract class SmasherWeaponItem extends WeaponItem{
    SmasherWeaponItem(AttackSpeed attackspeed, int statchange, Ability ability, String name) {
        super(attackspeed, statchange, ability, name);
    }
}
