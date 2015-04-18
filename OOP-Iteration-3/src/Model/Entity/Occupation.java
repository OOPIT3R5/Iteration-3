package Model.Entity;

public abstract class Occupation implements EquippableItemVisitor {

    private Entity entity;
    private Skill bindwounds;
    private Skill bargain;
    private Skill observation;

	public Occupation(Entity entity) {
        this.entity = entity;
        this.entity.setOccupation(this);
        bindwounds = new Skill(1, 10);
        bargain = new Skill(1, 10);
        observation = new Skill(1, 10);
    }

  
	protected Entity getEntity(){
        return entity;
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
}
