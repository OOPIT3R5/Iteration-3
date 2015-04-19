package Model.Items;

import View.Model.MapObjectView;

public class TwoHandedWeaponItem extends SmasherWeaponItem {

    private String name;

    public TwoHandedWeaponItem(int statchange, String name, MapObjectView mov) {
        super(AttackSpeed.SLOW, statchange, name, mov);
    }

    @Override
    public boolean isTwoHanded() {
        return true; //TWO-handeed weapon is two-handed. kk
    }
}