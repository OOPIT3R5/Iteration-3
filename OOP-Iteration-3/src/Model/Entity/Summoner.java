package Model.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import Model.Entity.Ability.Ability;
import Model.Entity.Ability.Blizzard;
import Model.Entity.Ability.Charm;
import Model.Entity.Ability.Fireball;
import Model.Entity.Ability.Polymorph;
import Model.Entity.Ability.Shock;
import Model.Entity.Ability.Sleep;
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

public class Summoner extends Occupation{

    private Skill enchantment;
    private Skill boon;
    private Skill bane;
    private Skill staff;
    
    private Ability enhanceAbil;
    private Ability hasteAbil;
    private Ability floatAbil;
    //enhance = boon
    //haste
    //float
    
    private Ability blizzAbil;
    private Ability fireballAbil;
    private Ability shockAbil;
    //blizzard = bane
    //fireball
    //shock
    private Ability charmAbil;
    private Ability sleepAbil;
    private Ability polymorphAbil;
    //charm = enchantment
    //sleep
    //polymorph
    
    
	public Summoner(Entity e){
        super(e);
        enchantment = new Skill(1, 10, "Enchantment");
        boon        = new Skill(1, 20, "Boon Spells");
        bane        = new Skill(1, 20, "Bane Spells");
        staff       = new Skill(1,  5, "Staff Whacking");
        
      /* BOONS
       * enhanceAbil = new Enhance(getEntity(),getEntity().map,boon);
        hasteAbil = new Haste(getEntity(),getEntity().map,boon);
        floatAbil = new Float(getEntity(),getEntity().map,boon);
       */
        
        blizzAbil = new Blizzard(getEntity(),bane);
        fireballAbil = new Fireball(getEntity(),bane);
        shockAbil = new Shock(getEntity(),bane);
        
        charmAbil = new Charm(getEntity(),enchantment);
        sleepAbil = new Sleep(getEntity(),enchantment);
        polymorphAbil = new Polymorph(getEntity(),enchantment);
	
	}

    @Override
	public String displayName() {
		// TODO Auto-generated method stub
		return "Summoner";
	}

    @Override
	protected HashMap<String, Ability> getAbilitiesSub() {
    	HashMap<String, Ability> abilities = new HashMap<String, Ability>();

		abilities.put("Blizzard", blizzAbil);
		abilities.put("Fireball", fireballAbil);
		abilities.put("Shock", shockAbil);
		
		abilities.put("Charm", charmAbil);
		abilities.put("Sleep", sleepAbil);
		abilities.put("Polymorph", polymorphAbil);
		
		return abilities;
		/* BOONS
		 * "Enhance", enhanceAbil;
	     * "Haste", hasteAbil;
	     * "Float", floatAbil;
	     */
	 	}

    @Override
    public Collection<? extends Skill> getSubSkills() {
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(enchantment);
        skills.add(boon);
        skills.add(bane);
        skills.add(staff);

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
        System.out.println("You are not able to equip the " + bwi.getName() + " due to being too weak!");
        getEntity().addToInventory(bwi);
    }

    @Override
    public void visit(OneHandedWeaponItem ohwi) {
        System.out.println("You are not able to equip the " + ohwi.getName() + " due to being too weak!");
        getEntity().addToInventory(ohwi);
    }

    @Override
    public void visit(ShoesItem si) {
        getEntity().equipItem(si);
    }

    @Override
    public void visit(SmasherShieldOffHandItem ssohi) {
        System.out.println("You cannot equip the "+ssohi.getName()+"! You can't carry a shield and cast a spell at someone at the same time.");
        getEntity().addToInventory(ssohi);
    }

    @Override
    public void visit(SneakWeaponItem snewi) {
        System.out.println("You are not able to equip the "+snewi.getName()+". Besides, it's not your style to sneak up on people.");
        getEntity().addToInventory(snewi);
    }

    @Override
    public void visit(SummonerTomeOffHandItem stohi) {
        getEntity().equipItem(stohi);
    }


    @Override
    public void visit(SummonerWeaponItem sumwi) {
        getEntity().equipItem(sumwi);
        getEntity().setActiveSkill(staff);
    }



	@Override
    public void visit(TwoHandedWeaponItem thwi) {
        System.out.println("You are not able to equip the " + thwi.getName() + " due to being too weak!");
        getEntity().addToInventory(thwi);
    }
    
    
    
    
}
