package Model.Items;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<TakeableItem> inventory;
    private int goldamount;

    public Inventory(){
        inventory = new ArrayList<TakeableItem>(50);
        goldamount = 0;
    }

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

    public int getGoldamount(){
        return goldamount;
    }

    public void addGold(int goldamount){
        this.goldamount += goldamount;
    }
}
