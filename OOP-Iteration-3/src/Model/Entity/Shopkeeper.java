package Model.Entity;

import Model.Items.TakeableItem;

public class Shopkeeper extends NonAdversarial {

	int costOfItem;
	int goldBuyFor;
	
	public Shopkeeper() {		// TODO Shopkeeper class
		super();	
		costOfItem = 5;
		goldBuyFor = 3;
	}
	
	
	public void bargianUsedOnMe(Skill s){
		costOfItem = 5 - 5*(s.getCurrentLevel()/50);
	}
	
	public void buy(TakeableItem ti){
		addToInventory(ti);
		getMap().getAvatar().awardGold(goldBuyFor);
	}
	
	@Override
	public void receiveDamage(int damage) {
			stats.changeHealth(-damage);
			becomeHostile();
		}
	
	 public void sell(TakeableItem ti){
		getMap().getAvatar().addToInventory(ti);
		if(costOfItem<getMap().getAvatar().getGold()){
			
		}
		else{
		getMap().getAvatar().stealGold(costOfItem);
		}
		awardGold(costOfItem);
	}

}
