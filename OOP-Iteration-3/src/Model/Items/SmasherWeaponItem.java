package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.TakeableItemVisitor;
import View.Model.MapObjectView;

public abstract class SmasherWeaponItem extends WeaponItem {
    SmasherWeaponItem(AttackSpeed attackspeed, int statchange, String name, MapObjectView mov) {
        super(attackspeed, statchange, name, mov);
    }
}
