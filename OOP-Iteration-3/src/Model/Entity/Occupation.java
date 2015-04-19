package Model.Entity;


import Model.Items.UsableItem;
import java.util.HashMap;
import java.util.Map;


public abstract class Occupation implements TakeableItemVisitor {





    private Entity entity;
    private Skill bindwounds;
    private Skill bargain;
    private Skill observation;

	public Occupation(Entity entity) {
        this.entity = entity;
        
        //BREAKING TDA fix!!!!
        this.entity.setOccupation(this);
        bindwounds = new Skill(1, 10);
        bargain = new Skill(1, 10);
        observation = new Skill(1, 10);
    }

  
	protected Entity getEntity(){
        return entity;
    }
	
	public HashMap<String,Skill> getSkills(){
		
		HashMap<String, Skill> skills = new HashMap<String, Skill>();
		skills.put("Bind Wounds", bindwounds);
		skills.put("Bargain", bargain);
		skills.put("Observation", observation);
		skills.putAll(getSkillsSub());
		return skills;
		
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

    protected abstract Map<? extends String, ? extends Skill> getSkillsSub();


	public int getBindWoundsSkillLevel(){
        return bindwounds.getCurrentLevel();
    }

    public int getBargainSkillLevel(){
        return bargain.getCurrentLevel();
    }

    public int getObservationSkillLevel(){
        return observation.getCurrentLevel();
    }

    public void levelBindWoundsSkill(){
        bindwounds.levelSkillUp();
    }

    public void levelBargainSkill(){
        bargain.levelSkillUp();
    }

    public void levelObservationSkill(){
        observation.levelSkillUp();
    }


	public void printName() {
		System.out.println(this.toString());
		
	}

    @Override

    public void visit(UsableItem ui){
        ui.execute();
    }
}
