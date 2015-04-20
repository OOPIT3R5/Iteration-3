package Model.Items;

import java.util.ArrayList;

import View.Model.MapObjectView;

public class Inventory {
    private ArrayList<TakeableItem> inventory;
    private int goldamount;

    public Inventory(){
        inventory = new ArrayList<TakeableItem>(50);
        goldamount = 50;
    }

    public void addGold(int goldamount){
        this.goldamount += goldamount;
    }

    public void addToInventory(TakeableItem ti){
        inventory.add(ti);
    }

    public TakeableItem getFromInventory(int index){
        if(index >= inventory.size())
            return null;
        TakeableItem ti = inventory.get(index);
        return ti;
    }
    
    public int getGoldamount(){
        return goldamount;
    }

    public ArrayList<MapObjectView> getViews() {
        ArrayList<MapObjectView> returned = new ArrayList<MapObjectView>();
        for(TakeableItem ti : inventory){
            returned.add(ti.getMapObjectView());
        }
        return returned;
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

    public TakeableItem takeFromInventory(int index){
        if(index >= inventory.size())
            return null;
        TakeableItem ti = inventory.get(index);
        inventory.remove(index);
        return ti;
    }

    public TakeableItem takeFromInventory(TakeableItem ti){
        inventory.remove(ti);
        return ti;
    }

    @Override
	public String toString()
    {
    	StringBuilder builder = new StringBuilder();
    	
    	for(TakeableItem t: inventory)
    	{
    		builder.append(t.toMyString());
    	}
    	
    	return builder.toString();
    }
}

