package Model.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import Model.Entity.Ability.Ability;
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
	public String displayName() {
		// TODO Auto-generated method stub
		return "Smasher";
	}

    @Override
	protected HashMap<String, Ability> getAbilitiesSub() {
		return null;
	}

    @Override
    public Collection<? extends Skill> getSubSkills() {
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(onehandedweapon);
        skills.add(twohandedweapon);
        skills.add(brawlingweapon);
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
        getEntity().equipItem(bwi);
        getEntity().setActiveSkill(brawlingweapon);
    }

    @Override
    public void visit(OneHandedWeaponItem ohwi) {
        getEntity().equipItem(ohwi);
        getEntity().setActiveSkill(onehandedweapon);
    }

    @Override
    public void visit(ShoesItem si) {
        getEntity().equipItem(si);
    }

    @Override
    public void visit(SmasherShieldOffHandItem ssohi) {
        getEntity().equipItem(ssohi);
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
    public void visit(SummonerWeaponItem sumwi) {
        getEntity().equipItem(sumwi);
    }



	@Override
    public void visit(TwoHandedWeaponItem thwi) {
        getEntity().equipItem(thwi);
        getEntity().setActiveSkill(twohandedweapon);
    }

}