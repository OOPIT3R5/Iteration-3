package Model.Entity;

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
	

}
