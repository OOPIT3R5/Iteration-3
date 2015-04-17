package Model.Items;

import Model.Entity.Ability.Ability;

public abstract class SmasherWeaponItem extends WeaponItem{
    SmasherWeaponItem(AttackSpeed attackspeed, Ability ability, String name) {
        super(attackspeed, ability, name);
    }
}
