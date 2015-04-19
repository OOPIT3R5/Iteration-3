package Model.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import Model.Entity.Ability.*;
import Model.Items.*;

public class Sneak extends Occupation{

    private Skill pickpocket;
    private Skill detecttraps;
    private Skill creep;
    private Skill rangedweapon;
    
    private Ability pickAbil;
    private Ability detectAbil;
    private Ability creepAbil;
    //ranged weapon is implicit

	public Sneak(Entity e){
        super(e);
        pickpocket  = new Skill(1,10, "Pickpocket");
        detecttraps = new Skill(1,10, "Detect Traps");
        creep       = new Skill(1,10, "Creep");
        rangedweapon= new Skill(1,25, "Ranged Weapons");
        
        pickAbil = new Pickpocket(getEntity(), getEntity().map, pickpocket);
        detectAbil = new DetectTrap(getEntity(),getEntity().map,detecttraps);
        creepAbil = new Creep(getEntity(), getEntity().map, creep);
    }

    @Override
    protected Map<? extends String, ? extends Ability> getAbilitiesSub() {
        return null;
    }

    //TODO: Replace all 'System.out.println()' methods with something with Logger.

   
	@Override
    public void visit(SmasherWeaponItem smawi) {
        System.out.println("You are not able to equip the "+smawi.getName()+" due to being too weak!");
        getEntity().addToInventory(smawi);
    }

    @Override
    public void visit(SummonerWeaponItem sumwi) {
        System.out.println("You are not able to equip the "+sumwi.getName()+" as it has a strange aura surrounding it.");
        getEntity().addToInventory(sumwi);
    }

    @Override
    public void visit(SneakWeaponItem snewi) {
        getEntity().equipItem(snewi);
    }

    @Override
    public void visit(SummonerTomeOffHandItem stohi) {
        System.out.println("You cannot equip the "+stohi.getName()+"! You don't want to damage your loot.");
        getEntity().addToInventory(stohi);
    }

    @Override
    public void visit(SmasherShieldOffHandItem ssohi) {
        System.out.println("You cannot equip the "+ssohi.getName()+"! You can't carry a shield and assassinate someone at the same time.");
        getEntity().addToInventory(ssohi);
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

    @Override
    public Collection<? extends Skill> getSubSkills() {
        ArrayList<Skill> skills = new ArrayList<Skill>();

        skills.add(pickpocket);
        skills.add(detecttraps);
        skills.add(creep);
        skills.add(rangedweapon);

        return skills;
    }
}
