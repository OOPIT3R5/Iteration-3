package Model.Entity;

import Model.Items.*;

public class Sneak extends Occupation{

	public Sneak(Entity e){
        super(e);
    }

    //TODO: Replace all 'System.out.println()' methods with something with Logger.

    @Override
    public void visit(SmasherWeaponItem smawi) {
        System.out.println("You are not able to equip the "+smawi.getName()+" due to being too weak!");
    }

    @Override
    public void visit(SummonerWeaponItem sumwi) {
        System.out.println("You are not able to equip the "+sumwi.getName()+" as it has a strange aura surrounding it.");
    }

    @Override
    public void visit(SneakWeaponItem snewi) {
        getEntity().equipItem(snewi);
    }

    @Override
    public void visit(SummonerTomeOffHandItem stohi) {
        System.out.println("You cannot equip the "+stohi.getName()+"! You don't want to damage your loot.");
    }

    @Override
    public void visit(SmasherShieldOffHandItem ssohi) {
        System.out.println("You cannot equip the "+ssohi.getName()+"! You can't carry a shield and assassinate someone at the same time.");
    }

    @Override
    public void visit(ArmorItem ai) {
        getEntity().equipItem(ai);
    }

    @Override
    public void visit(AccessoryItem acci) {
        getEntity().equipItem(acci);
    }

    @Override
    public void visit(ShoesItem si) {
        getEntity().equipItem(si);
    }
}
