package Model.Items;

import Model.Entity.Entity;

public class Equipment {
    //TODO: Get the Equipment all working!

    private WeaponItem weapon;
    private OffHandItem offhand;
    private ArmorItem armor;
    private AccessoryItem accessory;
    private ShoesItem shoes;
    private Entity entity; // This is a reference to the entity who "owns" us.


    public Equipment(Entity e){
        weapon = null;
        offhand = null;
        armor = null;
        accessory = null;
        shoes = null;
        entity = e;
    }

    public void equip(WeaponItem weaponitem){
        if(!isWeaponNull())
            unequipWeapon();        //If we already have a weapon equipped, unequip it first.

        if(weaponitem.isTwoHanded())
            unequipOffHandItem();   //We can't be having a two-handed weapon AND an off-hand item on, now can we?

        setWeapon(weaponitem);        //Set the new weaponitem.
    }
    public void equip(OffHandItem offhanditem){
        if(!isOffHandNull())
            unequipOffHandItem();   //If we already have an off-hand item, unequip it first.

        if(weapon.isTwoHanded())
            unequipWeapon();        //We can't be having a two-handed weapon AND an off-hand item on, now can we?

        setOffhand(offhanditem);      //Set the new offhand item.
    }
    public void equip(ArmorItem armoritem){
        if(!isArmorNull())
            unequipArmor();         //If we already have an armor equipped, unequip it first.

        setArmor(armoritem);        //Set the new armor item.
    }
    public void equip(AccessoryItem accessoryitem){
        if(!isAccessoryNull())
            unequipAccessory();     //If we have an accessory equipped, unequip it first.

        setAccessory(accessoryitem);//Set the new accessory item.
    }
    public void equip(ShoesItem shoesitem){
        if(!isShoesNull())
            unequipShoes();         //If we have shoes already equipped, unequip it first.

        setShoes(shoesitem);        //Set the new shoes item.
    }

    public void unequipWeapon(){
        entity.addToInventory(weapon);
        entity.getStatistics().addOffense(-1*weapon.getStatChangingValue());
        nullifyWeapon();
    }

    public void unequipOffHandItem(){
        entity.addToInventory(offhand);
        entity.getStatistics().addDefense(-1*offhand.getStatChangingValue());
        nullifyOffHand();
    }

    public void unequipArmor(){
        entity.addToInventory(armor);
        entity.getStatistics().addDefense(-1*armor.getStatChangingValue());
        nullifyArmor();
    }

    public void unequipAccessory(){
        entity.addToInventory(accessory);
        entity.getStatistics().addDefense(-1*accessory.getStatChangingValue());
        nullifyAccessory();
    }

    public void unequipShoes(){
        entity.addToInventory(shoes);
        entity.getStatistics().addDefense(-1*accessory.getStatChangingValue());
        nullifyShoes();
    }

    //Checks to see if we have any weapon equipped.
    private boolean isWeaponNull(){
        if(weapon == null)
            return true;
        else return false;
    }

    //Checks to see if we have any offhand equipped.
    private boolean isOffHandNull(){
        if(offhand == null)
            return true;
        else return false;
    }

    //Checks to see if we have any armor equipped.
    private boolean isArmorNull(){
        if(armor == null)
            return true;
        else return false;
    }

    //Checks to see if we have any accessory equipped.
    private boolean isAccessoryNull(){
        if(accessory == null)
            return true;
        else return false;
    }

    //Checks to see if we have any shoes equipped.
    private boolean isShoesNull(){
        if(shoes == null)
            return true;
        else return false;
    }

    private void setWeapon(WeaponItem weapon){
        this.weapon = weapon;
        entity.getStatistics().addOffense(weapon.getStatChangingValue());
    }

    private void setOffhand(OffHandItem offhand){
        this.offhand = offhand;
        entity.getStatistics().addDefense(offhand.getStatChangingValue());
    }

    private void setArmor(ArmorItem armor){
        this.armor = armor;
        entity.getStatistics().addDefense(armor.getStatChangingValue());
    }

    private void setAccessory(AccessoryItem accessory){
        this.accessory = accessory;
        entity.getStatistics().addDefense(accessory.getStatChangingValue());
    }

    private void setShoes(ShoesItem shoes){
        this.shoes = shoes;
        entity.getStatistics().addDefense(shoes.getStatChangingValue());
    }

    private void nullifyWeapon(){
        weapon = null;
    }

    private void nullifyOffHand(){
        offhand = null;
    }

    private void nullifyArmor(){
        armor = null;
    }

    private void nullifyAccessory(){
        accessory = null;
    }

    private void nullifyShoes(){
        shoes = null;
    }
}
