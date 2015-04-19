package Model.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import Model.Entity.Ability.*;
import Model.Items.*;

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
        
        blizzAbil = new Blizzard(getEntity(),getEntity().map,bane);
        fireballAbil = new Fireball(getEntity(),getEntity().map,bane);
        shockAbil = new Shock(getEntity(),getEntity().map,bane);
        
        charmAbil = new Charm(getEntity(),getEntity().map,enchantment);
        sleepAbil = new Sleep(getEntity(),getEntity().map,enchantment);
        polymorphAbil = new Polymorph(getEntity(),getEntity().map,enchantment);
	
	}



	@Override
    public void visit(SmasherWeaponItem smawi) {
        System.out.println("You are not able to equip the " + smawi.getName() + " due to being too weak!");
        getEntity().addToInventory(smawi);
    }

    @Override
    public void visit(SummonerWeaponItem sumwi) {
        getEntity().equipItem(sumwi);
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
    public void visit(SmasherShieldOffHandItem ssohi) {
        System.out.println("You cannot equip the "+ssohi.getName()+"! You can't carry a shield and cast a spell at someone at the same time.");
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
        skills.add(enchantment);
        skills.add(boon);
        skills.add(bane);
        skills.add(staff);

        return skills;
    }


    @Override
	protected HashMap<String, Ability> getAbilitiesSub() {
    	HashMap<String, Ability> abilities = new HashMap<String, Ability>();

		abilities.put("Blizzard",blizzAbil);
		abilities.put("Fireball",fireballAbil);
		abilities.put("Shock",shockAbil);
		
		abilities.put("Charm",charmAbil);
		abilities.put("Sleep",sleepAbil);
		abilities.put("Polymorph",polymorphAbil);
		
		return abilities;
		/* BOONS
		 * "Enhance", enhanceAbil;
	     * "Haste", hasteAbil;
	     * "Float", floatAbil;
	     */
	 	}
    
    
    
    
}
