package Model.Entity;

import java.util.ArrayList;

import Model.Entity.Ability.Ability;
import Model.Entity.Ability.DoNothing;
import Model.Entity.Ability.Move;
import Model.Items.Equipment;
import Model.Items.Inventory;
import Model.Items.TakeableItem;
import Model.Map.Direction;
import Model.Map.Location;

public class Entity implements MovementInterface {
	
	private Equipment equipmentManager;
	private Inventory inventory;
	private Location currentPosition;
	private ArrayList<Ability> movement_;
	
	public Entity(){
		//initialize movement
		ArrayList<Entity> entity_list = new ArrayList<Entity>();
		entity_list.add(this);
		movement_ = new ArrayList<Ability>();
		for (int i = 0; i < 6; i++) {
			movement_.add(new Move(entity_list, Direction.intToHex(i), 1));
		}
	}
	
	public void addToInventory(TakeableItem ti){
		inventory.addToInventory(ti);
	}

	@Override
	public void disableMove(int direction) {
		movement_.add(direction, new DoNothing(null));
	}

	@Override
	public void disableWalk(int direction) {
		movement_.add(direction, new DoNothing(null));
	}

	@Override
	public void enableMove(int direction) {
		ArrayList<Entity> entity_list = new ArrayList<Entity>();
		entity_list.add(this);
		movement_.add(direction, new Move(entity_list, Direction.intToHex(direction), 1));
	}
	public void setLocation(Location newPosition){
		this.currentPosition = newPosition;
	}
	public Location getLocation(){
		return this.currentPosition;
	}



}
