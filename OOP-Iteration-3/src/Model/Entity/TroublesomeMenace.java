package Model.Entity;

import Model.Entity.Ability.*;
import Model.Map.Direction;
import Utility.RandomGenerator;

public class TroublesomeMenace extends NonAdversarial implements Pet{
	
	boolean isOwned;
	PetOwnership po;
	
	public TroublesomeMenace(PetOwnership po) {
		super();
		po.setPet(this);
		isOwned = true;
		this.po = po;
	}
	
	/*AI stuff*/
	public void makeActionChoice(){
		Ability a;
		/*will never be hostile; will always either follow avatar (if owned),
		attack in vicinity, or go after treasure*/
		RandomGenerator randomlyGenerate = new RandomGenerator();
		double rand = randomlyGenerate.probability();
		Direction randDir = randomlyGenerate.direction();
		
		if(rand <.65 && isOwned){
			//65% chance of following (behind) avatar
			a = po.followAvatar();
		}
		else if(rand<.75){
			//10% chance of attacking in a random direction
			a = attackInVicinity();//change this so that it returns an ability
		}
		else if(rand <.95){
			//20% chance of running around in random direction in attempt to pick up item
			a = stealInVicinity();
		}
		else{
			//5% chance of doing nothing
			a = new DoNothing();
		}
		a.execute();
	}
	@Override
	public Ability attackInVicinity() {
		return new Attack(null, null);

		//find closest entity (not avatar), face, and attack
	}

	@Override
	public Ability stealInVicinity() {
		return new Move(this, getDirectionFacing(), getMovementSpeed());
		//can pickup item on tile
		//will race ahead of avatar(upto 2 tiles) in direction avatar is facing		
	}

}
