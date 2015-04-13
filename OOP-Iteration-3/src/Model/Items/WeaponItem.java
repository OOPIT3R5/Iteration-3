package Model.Items;

public abstract class WeaponItem extends EquippableItem{


    private AttackSpeed attackspeed;

    //Return weapon's attack speed
    public AttackSpeed getAttackSpeed(){
        return attackspeed;
    }

    //public abstract int getNumOfHands();
}
