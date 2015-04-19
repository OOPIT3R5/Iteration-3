package Model.Entity;



import Model.Entity.Ability.*;
import Model.Items.UsableItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public abstract class Occupation implements TakeableItemVisitor {


    private Entity entity;

    private Skill attack;
    private Skill bindwounds;
    private Skill bargain;
    private Skill observation;

    private Ability bindwoundsAbil;
    //private Ability bargainAbil;
    private Ability observeAbil;
    private Ability attackAbil;

    public Occupation(Entity entity) {
        this.entity = entity;

        //BREAKING TDA fix!!!!
        this.entity.setOccupation(this);
        attack = new Skill(1, 10, "Attack");
        bindwounds = new Skill(1, 10, "Bind Wounds");
        bargain = new Skill(1, 10, "Bargain");
        observation = new Skill(1, 10, "Observation");

        bindwoundsAbil = new BindWounds(entity, bindwounds);
        //bargainAbil= new Bargain(entity, bargain);
        observeAbil = new Observe(entity, entity.map, observation);
        attackAbil = new Attack(entity, entity.map, attack);
    }


    protected Entity getEntity() {
        return entity;
    }
	
/*	public HashMap<String,Skill> getSkills(){
		
		HashMap<String, Skill> skills = new HashMap<String, Skill>();
		skills.put("Bind Wounds", bindwounds);
		skills.put("Attack", attack);
		skills.put("Bargain", bargain);
		skills.put("Observation", observation);
		skills.putAll(getSkillsSub());
		return skills;
		
	}*/

    public ArrayList<Skill> getSkillAL() {
        ArrayList<Skill> skills = new ArrayList<Skill>();
        skills.add(bindwounds);
        skills.add(bargain);
        skills.add(observation);
        skills.addAll(getSubSkills());
        return skills;
    }

    public HashMap<String,Ability> getAbilities() {

        HashMap<String,Ability> abilities = new HashMap<String,Ability>();
        //attack

        abilities.put("Bind Wounds",bindwoundsAbil);
        abilities.put("Attack",attackAbil);
        abilities.put("Observe",observeAbil);
        //abilities.putAll(getAbilitiesSub());
        return abilities;

    }

    //Told that summoner tome isn't a thing anymore??? Potentially? by Ryan
	/*OFF HAND ITEMS THAT ARE CALLED "SUMMONERTOME" or "SMASHERSHIELD" BUT DON'T
	INHERIT FROM "SUMMONER WEAPON ITEM" OR "SMASHER WEAPON ITEM". I know they're not
	weapon's but these occupation specific items should share a common interface.
	ex. SummonerWeaponItem implements SummonerSpecificItem
		SmasherWeaponItem implements SmasherSpecificItem
		SneakSpecificItem implements SneakSpecificItem
		
		SummonerTome implements SummonerSpecificItem
		SmasherShield implements SmasherSpecificItem
		
		SummonerSpescificItem, SmasherSpecificItem, and SneakSpecificItem all are
		subclasses of OccupationSpecificItem
	*/

    protected abstract HashMap<String, Ability> getAbilitiesSub();
    
    public int getBindWoundsSkillLevel() {
        return bindwounds.getCurrentLevel();
    }

    public int getBargainSkillLevel() {
        return bargain.getCurrentLevel();
    }

    public int getObservationSkillLevel() {
        return observation.getCurrentLevel();
    }

    public void levelBindWoundsSkill() {
        bindwounds.levelSkillUp();
    }

    public void levelBargainSkill() {
        bargain.levelSkillUp();
    }

    public void levelObservationSkill() {
        observation.levelSkillUp();
    }


    public void printName() {
        System.out.println(this.toString());

    }

    @Override

    public void visit(UsableItem ui) {
        ui.execute();
    }

    public abstract Collection<? extends Skill> getSubSkills();
}
