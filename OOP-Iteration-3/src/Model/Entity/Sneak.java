package Model.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import Model.Entity.Ability.Ability;
import Model.Entity.Ability.Creep;
import Model.Entity.Ability.DetectTrap;
import Model.Entity.Ability.Pickpocket;
import Model.Items.AccessoryItem;
import Model.Items.ArmorItem;
import Model.Items.BrawlingWeaponItem;
import Model.Items.OneHandedWeaponItem;
import Model.Items.ShoesItem;
import Model.Items.SmasherShieldOffHandItem;
import Model.Items.SneakWeaponItem;
import Model.Items.SummonerTomeOffHandItem;
import Model.Items.SummonerWeaponItem;
import Model.Items.TwoHandedWeaponItem;

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
        
        pickAbil = new Pickpocket(getEntity(), pickpocket);
        detectAbil = new DetectTrap(getEntity(),detecttraps);
        creepAbil = new Creep(getEntity(), creep);
    }

    @Override
	public String displayName() {
		// TODO Auto-generated method stub
		return "Sneak";
	}

    //TODO: Replace all 'System.out.println()' methods with something with Logger.

    @Override
    protected HashMap<String, Ability> getAbilitiesSub(){
    	HashMap<String, Ability> abilities = new HashMap<String, Ability>();

        abilities.put("Pickpocket",pickAbil);
        abilities.put("Detect Traps",detectAbil);
        abilities.put("Creep",creepAbil);
//        abilities.add(rangedweapon);

        return abilities;
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

    @Override
    public void visit(AccessoryItem acci) {
        getEntity().equipItem(acci);
    }

    @Override
    public void visit(ArmorItem ai) {
        getEntity().equipItem(ai);
    }

    @Override
    public void visit(BrawlingWeaponItem bwi) {
        System.out.println("You are not able to equip the "+bwi.getName()+" due to being too weak!");
        getEntity().addToInventory(bwi);
    }

    @Override
    public void visit(OneHandedWeaponItem ohwi) {
        System.out.println("You are not able to equip the "+ohwi.getName()+" due to being too weak!");
        getEntity().addToInventory(ohwi);
    }

    @Override
    public void visit(ShoesItem si) {
        getEntity().equipItem(si);
    }

    @Override
    public void visit(SmasherShieldOffHandItem ssohi) {
        System.out.println("You cannot equip the "+ssohi.getName()+"! You can't carry a shield and assassinate someone at the same time.");
        getEntity().addToInventory(ssohi);
    }

    @Override
    public void visit(SneakWeaponItem snewi) {
        getEntity().equipItem(snewi);
        getEntity().setActiveSkill(rangedweapon);
    }

    @Override
    public void visit(SummonerTomeOffHandItem stohi) {
        System.out.println("You cannot equip the "+stohi.getName()+"! You don't want to damage your loot.");
        getEntity().addToInventory(stohi);
    }

    @Override
    public void visit(SummonerWeaponItem sumwi) {
        System.out.println("You are not able to equip the "+sumwi.getName()+" as it has a strange aura surrounding it.");
        getEntity().addToInventory(sumwi);
    }
    


	@Override
    public void visit(TwoHandedWeaponItem thwi) {
        System.out.println("You are not able to equip the "+thwi.getName()+" due to being too weak!");
        getEntity().addToInventory(thwi);
    }
}
