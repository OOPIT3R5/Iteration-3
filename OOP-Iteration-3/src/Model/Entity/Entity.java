package Model.Entity;

import Model.Items.Equipment;
import Model.Items.Inventory;
import Model.Items.TakeableItem;

public class Entity {
	
	private Equipment equipmentManager;
	private Inventory inventory;
	
	public Entity(){
		// empty constructor
	}
	
	public void addToInventory(TakeableItem ti){
		inventory.addToInventory(ti);
	}

}
