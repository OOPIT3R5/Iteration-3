package Model.Items;

import View.Model.MapObjectView;

public abstract class WeaponItem extends EquippableItem{

    private AttackSpeed attackspeed;

    WeaponItem(AttackSpeed attackspeed, int offense, String name, MapObjectView mov){
        super(offense, name, mov);
        this.attackspeed = attackspeed;
    }

    //Return weapon's attack speed
    public AttackSpeed getAttackSpeed(){
        return attackspeed;
    }

    public abstract boolean isTwoHanded();
}
