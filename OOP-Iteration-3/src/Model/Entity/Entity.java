package Model.Entity;

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;

import Model.Entity.Ability.Ability;
import Model.Entity.Ability.DoNothing;
import Model.Entity.Ability.Move;
import Model.Entity.Ability.SummonerAbility;
import Model.Items.AccessoryItem;
import Model.Items.ArmorItem;
import Model.Items.Equipment;
import Model.Items.EquippableItem;
import Model.Items.Inventory;
import Model.Items.OffHandItem;
import Model.Items.ShoesItem;
import Model.Items.TakeableItem;
import Model.Items.WeaponItem;
import Model.Map.Direction;
import Model.Map.GameMap;
import Model.Map.HexagonalLocation;
import Model.Map.Location;
import Model.Map.Grid.Tile.Tile;
import View.Model.MapObjectView;
import View.EntityView;
import View.InventoryView;

public abstract class Entity extends Observable implements MovementInterface {

	private static final Exception InvalidAbilityException = null;
	private String name;
	private Occupation occupation;
	private Direction directionFacing;
	//private Decal decal;		// TODO shouldn't this be a viewModel thing?
	
	private Equipment equipmentManager;
	private Inventory inventory;
    private StatisticContainer stats;
	private HexagonalLocation currentPosition;
	private Map<Direction,Ability> moveMap = new HashMap<Direction,Ability>();
	
	private EntityView entityView;
	
	private InventoryView inventoryView;
	private ArrayList<String> skillList = new ArrayList<String>();
	private int skillSelected = 0;
	
	//private int movementSpeed;
	
	private Skill activeSkill;

	protected int numOfPointsCanAllocateToLevelUpSkill = 3;

	protected GameMap map;
	
	/*Use */
	public Entity(){
		entityView = new EntityView();
		equipmentManager = new Equipment(this);
        inventory = new Inventory();
        stats = new StatisticContainer(this);
       // movementSpeed = 1;
        setDirection(Direction.NORTH);
        
        inventoryView = new InventoryView(this);
        
      //  decal = new Decal();
	}
	/*
	public Decal getDecal() {
		// TODO Auto-generated method stub
		return decal;
	}
	
	public void setDecal(Decal d) {
		//TODO 
		decal = d;
	}*/
	
	
	public Entity (String name){
		this();
		this.name = name;
		this.occupation = new Smasher(this);
	}
	
	public Entity (String name, Occupation o){
		this(name);
		occupation = o;
	}
	
	public Skill getActiveSkill(){
		return activeSkill;
	}
	
	public void setActiveSkill(Skill skill){
		activeSkill = skill;
	}
	
	public GameMap getGamemap(){
		return map;
	}
	
	public void addToInventory(TakeableItem ti){
		inventory.addToInventory(ti);
	}
	
	public void alertNeighboringTiles(){
		Location center = getLocation();
		for(Entry<Direction, Ability> entry: moveMap.entrySet()){
			Direction currentDirection = entry.getKey();
			Tile neighboringTile = map.getTile(center.getNeighbor(currentDirection));
			neighboringTile.prospectiveMovement(this,currentDirection);
		}
	}
	
	public void autoLevelUp() {
        awardExperience(1000 - stats.getExperience()); //Get the remaining amt of EXP needed to level up and add that to ourselves.
        numOfPointsCanAllocateToLevelUpSkill++;
    }
	
	
	public void awardExperience(int award){
        stats.awardExperience(award);
    }
	
	public void awardGold(int gold){
        inventory.addGold(gold);
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
	
	public void regenMana(){
		getStatistics().regenMana();
	}
	
	@Override
	public void disableMove(Direction direction) {
		moveMap.put(direction, new DoNothing());
	}

    public void removeFromMap(){
        map.getTile(getLocation()).removeEntity(); //Removes entity from map.
    }

    @Override
	public void disableWalk(Direction direction) {
		moveMap.put(direction, new DoNothing());
	}

    @Override
	public void enableMove(Direction direction) {
		moveMap.put(direction, new Move(this, direction, this.getMovementSpeed()));
	}
    
    //Use this method to equip any EquippableItem (from Inventory, etc.)
    public void equipEquippableItem(EquippableItem ei){
        ei.accept(occupation);
    }

    void equipItem(AccessoryItem acci){
        equipmentManager.equip(acci);
    }
    
    void equipItem(ArmorItem ai){
        equipmentManager.equip(ai);
    }
    
    void equipItem(OffHandItem ohi){
        equipmentManager.equip(ohi);
    }
    
    void equipItem(ShoesItem si){
        equipmentManager.equip(si);
    }
    //end of package protected methods to be called ONLY by the occupations
    
    //The below equip methods are package-protected. They should oly be called by Occupation due to the Visitor pattern. Please use the above method (equipEquippableItem()) to globally make an Entity equip an item.
    void equipItem(WeaponItem wi){
        equipmentManager.equip(wi);
    }
	

    public void examineItem(String s){
		inventoryView.setInfo(s);
	}
    public Direction getDirectionFacing(){
		return directionFacing;
	}
    public MapObjectView[] getEquipmentViews() throws IOException {
        return equipmentManager.getViews();
    }
    public int getGold(){
        return inventory.getGoldamount();
    }
    public ArrayList<MapObjectView> getInventory() {
        return inventory.getViews();
    }

    public InventoryView getInventoryView(){
		return inventoryView;
	}

    public TakeableItem getItem(int inventoryIndex){
    	TakeableItem ti = inventory.getFromInventory(inventoryIndex);
        return inventory.getFromInventory(inventoryIndex);
    }

    public HexagonalLocation getLocation(){
		return this.currentPosition;
	}

    public Location getLocationFacing() {
		return getLocation().getNeighbor(getDirectionFacing());
	}

    public int getMovementSpeed(){
		return stats.getMovement();
	}

    public Occupation getOccupation() {
		return occupation;
	}

    public void getOccupationTestMethod() {
		occupation.printName();
	}

    public int getskillPoints(){
		return numOfPointsCanAllocateToLevelUpSkill;
	}

    public void useSkillPoint(){
        numOfPointsCanAllocateToLevelUpSkill--;
    }
    
    public StatisticContainer getStatistics(){
        return stats;
    }

    
    public void makeActionChoice() {
		// hook
	}
	
	public void moveNorth(){
		moveMap.get(Direction.NORTH).execute();
		alertNeighboringTiles();
	}

	public void moveNortheast(){
		moveMap.get(Direction.NORTHEAST).execute();
		alertNeighboringTiles();
	}
	
	public void moveNorthwest(){
		moveMap.get(Direction.NORTHWEST).execute();
		alertNeighboringTiles();
	}

	public void moveSouth(){
		moveMap.get(Direction.SOUTH).execute();
		alertNeighboringTiles();
	}
	
    public void moveSoutheast(){
		moveMap.get(Direction.SOUTHEAST).execute();
		alertNeighboringTiles();
	}

    public void moveSouthwest(){
		moveMap.get(Direction.SOUTHWEST).execute();
		alertNeighboringTiles();
	}

    public void observe(){
		// TODO send info about Entity to log/output
	}
    
    public void receiveDamage(int damage) {
		stats.changeHealth(-damage);		
	}

	public void setDirection(Direction d){
		directionFacing = d;
	}
	
	public void setLocation(HexagonalLocation newPosition){
		this.currentPosition = newPosition;
	}

	public void setMap(GameMap map){
		this.map = map;

		moveMap.put(Direction.NORTH, (new Move(this,Direction.NORTH,stats.getMovement())));
		moveMap.put(Direction.NORTHEAST, (new Move(this,Direction.NORTHEAST,stats.getMovement())));
		moveMap.put(Direction.NORTHWEST, (new Move(this,Direction.NORTHWEST,stats.getMovement())));
		moveMap.put(Direction.SOUTH, (new Move(this,Direction.SOUTH,stats.getMovement())));
		moveMap.put(Direction.SOUTHEAST, (new Move(this,Direction.SOUTHEAST,stats.getMovement())));
		moveMap.put(Direction.SOUTHWEST, (new Move(this,Direction.SOUTHWEST,stats.getMovement())));

	}

	protected void setOccupation(Occupation o) {
		occupation = o;	
	}

	public int stealGold(int gold){
        return inventory.stealGold(gold);
    }
	
	public void unequipAccessory(){
        equipmentManager.unequipAccessory();
    }

	public void unequipArmor(){
        equipmentManager.unequipArmor();
    }
	
	public void unequipOffHand(){
        equipmentManager.unequipOffHandItem();
    }
	
	public void unequipShoes(){
        equipmentManager.unequipShoes();
    }
	
	//can't award more than numOfPointsCanAllocateToLevelUpSkill
    public void unequipWeapon(){
        equipmentManager.unequipWeapon();
    }
	
	public void useMana(SummonerAbility summonerAbility) {		// TODO useMana()
		int requiredMana = summonerAbility.getRequiredMana();
		if (stats.useMana(requiredMana)){
			summonerAbility.cast();
		}
		
	}
	
	public abstract void performAction();
	
	public void utilizeTakeableItem(int inventoryIndex){
        TakeableItem ti = inventory.takeFromInventory(inventoryIndex);
        if(ti != null) {
            System.out.println("You're going to equip the " + ti.getName() + "!");
            ti.accept(occupation);
        }
    }
	
	public abstract void render(Graphics g, HexagonalLocation center);
	
	public void ability(String s){
		Ability a = (occupation.getAbilities().get(s));
		try {
			a.execute();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Invalid Ability");
		}
	}
	
	public void changeMovementSpeed(int delta){
		int newSpeed = stats.getMovement() + delta;
		stats.increaseSpeed(newSpeed);
	}
	
	public String toString()
	{
		return this.name + " , " +  this.currentPosition.toString();
	}
}
