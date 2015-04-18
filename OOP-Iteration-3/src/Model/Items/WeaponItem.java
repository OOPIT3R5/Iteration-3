package Model.Items;

import Model.Entity.Ability.Ability;

public abstract class WeaponItem extends EquippableItem{

    private AttackSpeed attackspeed;

    WeaponItem(AttackSpeed attackspeed, int offense, Ability ability, String name){
        super(offense, ability, name);
        this.attackspeed = attackspeed;
    }

    //Return weapon's attack speed
    public AttackSpeed getAttackSpeed(){
        return attackspeed;
    }

    public abstract boolean isTwoHanded();
}
