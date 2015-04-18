package Model.Entity;

import Model.Items.*;

public class Summoner extends Occupation{

	public Summoner(Entity e){
        super(e);
    }

    @Override
    public void visit(SmasherWeaponItem smawi) {
        System.out.println("You are not able to equip the "+smawi.getName()+" due to being too weak!");
    }

    @Override
    public void visit(SummonerWeaponItem sumwi) {
        getEntity().equipItem(sumwi);
    }

    @Override
    public void visit(SneakWeaponItem snewi) {
        System.out.println("You are not able to equip the "+snewi.getName()+". Besides, it's not your style to sneak up on people.");
    }

    @Override
    public void visit(SummonerTomeOffHandItem stohi) {
        getEntity().equipItem(stohi);
    }

    @Override
    public void visit(SmasherShieldOffHandItem ssohi) {
        System.out.println("You cannot equip the "+ssohi.getName()+"! You can't carry a shield and cast a spell at someone at the same time.");
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
