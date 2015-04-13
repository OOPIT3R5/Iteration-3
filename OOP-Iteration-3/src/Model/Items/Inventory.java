package Model.Items;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<TakeableItem> inventory = new ArrayList<TakeableItem>(50);

    /******
     * PUBLIC INTERFACE
     */
    public void addToInventory(TakeableItem ti){
        inventory.add(ti);
    }

    public boolean removeFromInventory(TakeableItem ti){
        return inventory.remove(ti);
    }

    //public TakeableItem
}
