package Model.Entity;

import java.util.ArrayList;

import Model.Entity.Ability.Ability;
import Model.Entity.Ability.DoNothing;
import Model.Entity.Ability.Move;
import Model.Items.*;
import Model.Map.Direction;
import Model.Map.Location;

public class Entity implements MovementInterface {
	
	
/*	private final int SMASHER = 0;
	private final int SUMMONER = 1;
	private final int SNEAK = 2;
	*/
	private String name;
	private Occupation occupation;
	//private StatisticsContainer stats;
	private Direction directionFacing;
	//private Decal decal;
	
	private Equipment equipmentManager;
	private Inventory inventory;
    private StatisticContainer stats;
	private Location currentPosition;
	private ArrayList<Ability> movement_;
	
	private int movementSpeed;
	
	/*Use */
	public Entity(){
		//initialize movement
		ArrayList<Entity> entity_list = new ArrayList<Entity>();
		entity_list.add(this);
		movement_ = new ArrayList<Ability>();
		for (int i = 0; i < 6; i++) {
			movement_.add(new Move(this, Direction.intToHex(i), 1));
		}

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
	
	public void addToInventory(TakeableItem ti){
		inventory.addToInventory(ti);
	}


    //Use this method to equip any EquippableItem (from Inventory, etc.)
    public void equipEquippableItem(EquippableItem ei){
        ei.accept(occupation);
    }

    //The below methods are package-protected. They should oly be called by Occupation due to the Visitor pattern. Please use the above method (equipEquippableItem()) to globally make an Entity equip an item.
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

    public void awardExperience(int award){
        stats.awardExperience(award);
    }
    
    public StatisticContainer getStatistics(){
        return stats;
    }

    @Override
	public void disableMove(int direction) {
		movement_.add(direction, new DoNothing());
	}

	public void disableWalk(int direction) {
		movement_.add(direction, new DoNothing());
	}

	public void enableMove(int direction) {
		ArrayList<Entity> entity_list = new ArrayList<Entity>();
		entity_list.add(this);
		movement_.add(direction, new Move(this, Direction.intToHex(direction), 1));
	}
	
	public void setLocation(Location newPosition){
		this.currentPosition = newPosition;
	}

	public Location getLocation(){
		return this.currentPosition;
	}

}
