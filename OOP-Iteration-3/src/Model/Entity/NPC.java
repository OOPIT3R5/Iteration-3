package Model.Entity;

import Utility.RandomlyGenerate;

public class NPC extends Entity {

	private Hostility hostility;
	public NPC(){
		super();
		hostility = new Hostility(this);
	}
	
	/*AI stuff*/
	public void makeActionChoice(){
		hostility.act();
	}

	public boolean avatarIsWithinRange() {
		//is avatar within one tile of entity?
		//
		return false;
	}
	
	public void provoke(){
		double rand = RandomlyGenerate.probability();
		if (rand>.10){
			hostility.setHostility(true);
		}
	}
	

}
