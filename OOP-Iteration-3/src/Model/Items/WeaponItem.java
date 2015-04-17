package Model.Items;

import Model.Entity.Ability.Ability;

public abstract class WeaponItem extends EquippableItem{

    private String name;
    private AttackSpeed attackspeed;

    WeaponItem(AttackSpeed attackspeed, Ability ability, String name){
        super(ability, name);
        this.attackspeed = attackspeed;
    }

    //Return weapon's attack speed
    public AttackSpeed getAttackSpeed(){
        return attackspeed;
    }

    public abstract boolean isTwoHanded();
}
