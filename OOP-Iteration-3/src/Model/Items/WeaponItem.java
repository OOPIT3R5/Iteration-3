package Model.Items;

import Model.Entity.Ability.Ability;
import View.MapObjectView;

public abstract class WeaponItem extends EquippableItem{

    private AttackSpeed attackspeed;

    WeaponItem(AttackSpeed attackspeed, int offense, Ability ability, String name, MapObjectView mov){
        super(offense, ability, name, mov);
        this.attackspeed = attackspeed;
    }

    //Return weapon's attack speed
    public AttackSpeed getAttackSpeed(){
        return attackspeed;
    }

    public abstract boolean isTwoHanded();
}
