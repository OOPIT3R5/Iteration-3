package Model.Entity;

public abstract class Occupation implements EquippableItemVisitor {

    private Entity entity;

	public Occupation(Entity entity) {
        this.entity = entity;
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
	

}
