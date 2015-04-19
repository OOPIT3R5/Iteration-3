package Model.Items;

import View.MapObjectView;

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
        if(index >= inventory.size())
            return null;
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

    public int stealGold(int gold) {
        if((goldamount - gold) < 0){
            int tempgoldamount = goldamount;
            goldamount = 0;
            return tempgoldamount;
        }
        else{
        	goldamount -= gold;
        	return (gold);
        }
    }

    public ArrayList<MapObjectView> getViews() {
        ArrayList<MapObjectView> returned = new ArrayList<MapObjectView>();
        for(TakeableItem ti : inventory){
            returned.add(ti.getMapObjectView());
        }
        return returned;
    }
}
