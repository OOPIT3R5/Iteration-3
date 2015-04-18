package Model.Items;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<TakeableItem> inventory = new ArrayList<TakeableItem>(50);

    public void addToInventory(TakeableItem ti){
        inventory.add(ti);
    }

    public TakeableItem takeFromInventory(TakeableItem ti){
        inventory.remove(ti);
        return ti;
    }

    public TakeableItem takeFromInventory(int index){
        TakeableItem ti = inventory.get(index);
        inventory.remove(index);
        return ti;
    }
}
