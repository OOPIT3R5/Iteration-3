package Model.Entity;

import Utility.RandomlyGenerate;

public class NPC extends Entity {

	protected Hostility hostility;
	public NPC(){
		super();
		hostility = new Hostility(this);
	}
	
	public NPC(String name, Occupation o) {
		super(name, o);
		hostility = new Hostility(this);
	}

	public NPC(String name) {
		super(name);
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
	
	protected void becomeHostile() {
		hostility.becomeHostile();
	}
	
	public void provoke(){
		double rand = RandomlyGenerate.probability();
		if (rand>.10){
			becomeHostile();
		}
	}
	

}
