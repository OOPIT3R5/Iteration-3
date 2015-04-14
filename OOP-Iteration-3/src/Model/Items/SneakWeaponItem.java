package Model.Items;

public class SneakWeaponItem extends WeaponItem{
    @Override
    public boolean isTwoHanded() {
        return true; //Assuming all sneak weapons are 2-handed
    }
}
