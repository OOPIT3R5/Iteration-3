package Model.Items;

public class OneHandedWeaponItem extends SmasherWeaponItem {

    @Override
    public boolean isTwoHanded() {
        return false;//One handed sword, duh
    }
}
