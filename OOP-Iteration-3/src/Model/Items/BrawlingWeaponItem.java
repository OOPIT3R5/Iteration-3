package Model.Items;

import Model.Entity.Ability.Ability;
import View.Model.MapObjectView;

public class BrawlingWeaponItem extends SmasherWeaponItem {
    BrawlingWeaponItem(int statchange,String name, MapObjectView mov) {
        super(AttackSpeed.FAST, statchange,name, mov);
    }

    @Override
    public boolean isTwoHanded() {
        return true;//Brawling with BOTH HANDS BABY
    }
}
