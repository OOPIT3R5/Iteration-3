package Model.Entity;

import java.io.IOException;
import java.util.ArrayList;

import Model.Entity.Ability.Ability;
import Model.Entity.Ability.DoNothing;
import Model.Entity.Ability.Move;
import Model.Entity.Ability.SummonerAbility;
import Model.Items.*;
import Model.Map.Direction;
import Model.Map.GameMap;
import Model.Map.Location;
import View.MapObjectView;

public class Entity implements MovementInterface {

	private String name;
	private Occupation occupation;
	private Direction directionFacing;
	//private Decal decal;
	
	private Equipment equipmentManager;
	private Inventory inventory;
    private StatisticContainer stats;
	private Location currentPosition;
	private ArrayList<Ability> movement_;
	
	private int movementSpeed;

	//rename. ALSO NUMBER OF POINTS IS 1 FOR TESTING PURPOSES ONLY. CHANGE BACK!!!
	protected int numOfPointsCanAllocateToLevelUpSkill = 1;

	protected GameMap map;
	
	/*Use */
	public Entity(){
		//initialize movement
		ArrayList<Entity> entity_list = new ArrayList<Entity>();
		entity_list.add(this);
		movement_ = new ArrayList<Ability>();
		movement_.add(new Move(this,map,Direction.NORTH,movementSpeed));
		movement_.add(new Move(this,map,Direction.NORTHEAST,movementSpeed));
		movement_.add(new Move(this,map,Direction.NORTHWEST,movementSpeed));
		movement_.add(new Move(this,map,Direction.SOUTH,movementSpeed));
		movement_.add(new Move(this,map,Direction.SOUTHEAST,movementSpeed));
		movement_.add(new Move(this,map,Direction.SOUTHWEST,movementSpeed));
		
        equipmentManager = new Equipment(this);
        inventory = new Inventory();
        stats = new StatisticContainer();
        movementSpeed = 1;
	}
	
	public Entity (String name){
		this();
		this.name = name;
		this.occupation = new Smasher(this);
	}
	
	public Entity (String name, Occupation o){
		this(name);
		occupation = o;
	}
	
	public int getMovementSpeed(){
		return movementSpeed;
	}
	
	public Direction getDirectionFacing(){
		return directionFacing;
	}
	
	public int getskillPoints(){
		return numOfPointsCanAllocateToLevelUpSkill;
	}
	
	public void addToInventory(TakeableItem ti){
		inventory.addToInventory(ti);
	}
	
	public void setDirection(Direction d){
		directionFacing = d;
	}


    //Use this method to equip any EquippableItem (from Inventory, etc.)
    public void equipEquippableItem(EquippableItem ei){
        ei.accept(occupation);
    }

    public void utilizeTakeableItem(int inventoryIndex){
        TakeableItem ti = inventory.takeFromInventory(inventoryIndex);
        if(ti != null) {
            System.out.println("You're going to equip the " + ti.getName() + "!");
            ti.accept(occupation);
        }
    }

    //The below equip methods are package-protected. They should oly be called by Occupation due to the Visitor pattern. Please use the above method (equipEquippableItem()) to globally make an Entity equip an item.
    void equipItem(WeaponItem wi){
        equipmentManager.equip(wi);
    }
    
    void equipItem(OffHandItem ohi){
        equipmentManager.equip(ohi);
    }
    
    void equipItem(ArmorItem ai){
        equipmentManager.equip(ai);
    }
    
    void equipItem(AccessoryItem acci){
        equipmentManager.equip(acci);
    }
    
    void equipItem(ShoesItem si){
        equipmentManager.equip(si);
    }
    //end of package protected methods to be called ONLY by the occupations

    	//can't award more than numOfPointsCanAllocateToLevelUpSkill
    public void unequipWeapon(){
        equipmentManager.unequipWeapon();
    }
    public void unequipOffHand(){
        equipmentManager.unequipOffHandItem();
    }
    public void unequipArmor(){
        equipmentManager.unequipArmor();
    }
    public void unequipAccessory(){
        equipmentManager.unequipAccessory();
    }
    public void unequipShoes(){
        equipmentManager.unequipShoes();
    }

    public void awardExperience(int award){
        stats.awardExperience(award);
    }

    public void awardGold(int gold){
        inventory.addGold(gold);
    }

    public int stealGold(int gold){
        return inventory.stealGold(gold);
    }

    public int getGold(){
        return inventory.getGoldamount();
    }

    public void changeHealth(int change){
        stats.changeHealth(change);
    }

    public void checkMana(SummonerAbility sa){
        if(sa.getRequiredMana() <= getStatistics().getMana()){
            getStatistics().useMana(sa.getRequiredMana());
            sa.cast();
        }
    }

    public StatisticContainer getStatistics(){
        return stats;
    }

    public MapObjectView[] getEquipmentViews() throws IOException {
        return equipmentManager.getViews();
    }
    @Override
	public void disableMove(Direction direction) {
		movement_.add(Direction.hexToInt(direction), new DoNothing());
	}
    
    @Override
	public void disableWalk(Direction direction) {
		movement_.add(Direction.hexToInt(direction), new DoNothing());
	}
    
    @Override
	public void enableMove(Direction direction) {
		ArrayList<Entity> entity_list = new ArrayList<Entity>();
		entity_list.add(this);
		// TODO movement_.add(Direction.hexToInt(direction), new Move(this, direction, 1));
	}
	
	public void setLocation(Location newPosition){
		this.currentPosition = newPosition;
	}

	public Location getLocation(){
		return this.currentPosition;
	}
	
	public Location getLocationFacing() {
		return getLocation().getNeighbor(getDirectionFacing());
	}

	protected void setOccupation(Occupation o) {
		occupation = o;	
	}
	
    public void autoLevelUp() {
        awardExperience(1000 - stats.getExperience()); //Get the remaining amt of EXP needed to level up and add that to ourselves.
        numOfPointsCanAllocateToLevelUpSkill++;
    }


    public ArrayList<MapObjectView> getInventory() {
        return inventory.getViews();
    }

    public void useSkillPoint(){
        numOfPointsCanAllocateToLevelUpSkill--;
    }



	public void makeActionChoice() {
		// hook
	}

	public void getOccupationTestMethod() {
		occupation.printName();
	}

	public void sleep() {
		// TODO Auto-generated method stub
	}
	
	public void observe(){
		
	}

	public void receiveDamage(int damage) {
		stats.changeHealth(-damage);		
	}

	public void charm() {
		// TODO Auto-generated method stub
	}

	public void polymorph() {
		// TODO Auto-generated method stub
	}


	public void useMana(SummonerAbility summonerAbility) {
		// TODO Auto-generated method stub
	}

	public Occupation getOccupation() {
		return occupation;
	}

}
