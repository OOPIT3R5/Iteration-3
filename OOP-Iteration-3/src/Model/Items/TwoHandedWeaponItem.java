package Model.Items;

import Model.Entity.Ability.Ability;
import View.MapObjectView;

public class TwoHandedWeaponItem extends SmasherWeaponItem {

    private String name;

    TwoHandedWeaponItem(int statchange, Ability ability, String name, MapObjectView mov) {
        super(AttackSpeed.SLOW, statchange, ability, name, mov);
    }

    @Override
    public boolean isTwoHanded() {
        return true; //TWO-handeed weapon is two-handed. kk
    }
}
