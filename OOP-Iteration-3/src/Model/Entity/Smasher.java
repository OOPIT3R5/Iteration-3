package Model.Entity;

import java.util.*;

import Model.Entity.Ability.Ability;
import Model.Items.*;

public class Smasher extends Occupation{
    private Skill onehandedweapon;
    private Skill twohandedweapon;
    private Skill brawlingweapon;
    
    
   // private Ability onehandAbil;
   // private Ability twohandAbil;
   // private Ability brawlAbil;

	public Smasher(Entity e) {
        super(e);
        onehandedweapon = new Skill(1, 25, "One-Handed Weapons");
        twohandedweapon = new Skill(1, 25, "Two-Handed Weapons");
        brawlingweapon  = new Skill(1, 25, "Brawling Weapons");
	}


    @Override
    public void visit(OneHandedWeaponItem ohwi) {
        getEntity().equipItem(ohwi);
        getEntity().setActiveSkill(onehandedweapon);
    }

    @Override
    public void visit(TwoHandedWeaponItem thwi) {
        getEntity().equipItem(thwi);
        getEntity().setActiveSkill(twohandedweapon);
    }

    @Override
    public void visit(BrawlingWeaponItem bwi) {
        getEntity().equipItem(bwi);
        getEntity().setActiveSkill(brawlingweapon);
    }

    @Override
    public void visit(SummonerWeaponItem sumwi) {
        getEntity().equipItem(sumwi);
    }

    @Override
    public void visit(SneakWeaponItem snewi) {
        getEntity().equipItem(snewi);
    }

    @Override
    public void visit(SummonerTomeOffHandItem stohi) {
        System.out.println("You can't equip this! A book does not make a good shield!");
        getEntity().addToInventory(stohi);
    }

    @Override
    public void visit(SmasherShieldOffHandItem ssohi) {
        getEntity().equipItem(ssohi);
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
        skills.add(onehandedweapon);
        skills.add(twohandedweapon);
        skills.add(brawlingweapon);
        return skills;
    }


    protected HashMap<String, Ability> getAbilitiesSub() {
		
		return null;
	}

}