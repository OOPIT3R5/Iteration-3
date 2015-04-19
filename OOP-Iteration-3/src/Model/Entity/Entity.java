package Model.Entity;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import Model.Entity.Ability.Ability;
import Model.Entity.Ability.DoNothing;
import Model.Entity.Ability.Move;
import Model.Entity.Ability.SummonerAbility;
import Model.Items.*;
import Model.Map.Direction;
import Model.Map.GameMap;
import Model.Map.HexagonalLocation;
import Model.Map.Location;
import Model.Map.Grid.Tile.Tile;
import View.InventoryView;
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
	private Map<Direction,Ability> moveMap = new HashMap<Direction,Ability>();
	
	private InventoryView inventoryView;
	private ArrayList<String> skillList = new ArrayList<String>();
	private int skillSelected = 0;
	
	private int movementSpeed;

	//TODO rename. ALSO NUMBER OF POINTS IS 1 FOR TESTING PURPOSES ONLY. CHANGE BACK!!!
	protected int numOfPointsCanAllocateToLevelUpSkill = 1;

	protected GameMap map;
	
	/*Use */
	public Entity(){
		equipmentManager = new Equipment(this);
        inventory = new Inventory();
        stats = new StatisticContainer();
        movementSpeed = 1;
        
        inventoryView = new InventoryView(this);
	}
	
	public InventoryView getInventoryView(){
		return inventoryView;
	}
	
	public void examineItem(String s){
		inventoryView.setInfo(s);
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
	
	public Entity (GameMap map){
		this();
		this.map = map;
		moveMap.put(Direction.NORTH, (new Move(this,map,Direction.NORTH,movementSpeed)));
		moveMap.put(Direction.NORTHEAST, (new Move(this,map,Direction.NORTHEAST,movementSpeed)));
		moveMap.put(Direction.NORTHWEST, (new Move(this,map,Direction.NORTHWEST,movementSpeed)));
		moveMap.put(Direction.SOUTH, (new Move(this,map,Direction.SOUTH,movementSpeed)));
		moveMap.put(Direction.SOUTHEAST, (new Move(this,map,Direction.SOUTHEAST,movementSpeed)));
		moveMap.put(Direction.SOUTHWEST, (new Move(this,map,Direction.SOUTHWEST,movementSpeed)));
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
    
    public TakeableItem getItem(int inventoryIndex){
    	TakeableItem ti = inventory.getFromInventory(inventoryIndex);
        return inventory.getFromInventory(inventoryIndex);
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
		moveMap.put(direction, new DoNothing());
	}
    
    @Override
	public void disableWalk(Direction direction) {
		moveMap.put(direction, new DoNothing());
	}
    
    @Override
	public void enableMove(Direction direction) {
		moveMap.put(direction, new Move(this, map, direction, this.getMovementSpeed()));
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
    
    public void incSkill(Skill s){
    	if(numOfPointsCanAllocateToLevelUpSkill > 0){
    		s.levelSkillUp();
    	}
    }

	public void makeActionChoice() {
		// hook
	}

	public void getOccupationTestMethod() {
		occupation.printName();
	}
	
	public void observe(){
		
	}

	public void receiveDamage(int damage) {
		stats.changeHealth(-damage);		
	}

	public void useMana(SummonerAbility summonerAbility) {		// TODO useMana()
	}

	public Occupation getOccupation() {
		return occupation;
	}
	
	public void alertNeighboringTiles(){
		Location center = getLocation();
		
		for(Entry<Direction, Ability> entry: moveMap.entrySet()){
			Direction currentDirection = entry.getKey();
			Tile neighboringTile = map.getTile(center.getNeighbor(currentDirection));
			neighboringTile.prospectiveMovement(this,currentDirection);
		}
	}

	protected void setLocation(HexagonalLocation loc)
	{
		this.currentPosition = loc;
	}
	
}
