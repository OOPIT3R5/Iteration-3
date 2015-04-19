package Model.Items;

import Model.Entity.Ability.Ability;
import View.Model.MapObjectView;

public class BrawlingWeaponItem extends SmasherWeaponItem {
    BrawlingWeaponItem(int statchange, Ability ability, String name, MapObjectView mov) {
        super(AttackSpeed.FAST, statchange, ability, name, mov);
    }

    @Override
    public boolean isTwoHanded() {
        return true;//Brawling with BOTH HANDS BABY
    }
}
