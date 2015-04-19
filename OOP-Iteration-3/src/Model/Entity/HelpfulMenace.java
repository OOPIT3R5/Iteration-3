package Model.Entity;

import Model.Entity.Ability.Ability;
import Model.Entity.Ability.Attack;
import Model.Entity.Ability.DoNothing;
import Model.Entity.Ability.Move;

import Model.Map.Direction;

import Utility.RandomlyGenerate;

public class HelpfulMenace extends NonAdversarial implements Pet{

	PetOwnership po;
	boolean isOwned;
	
	public HelpfulMenace(PetOwnership po) {
		super();
		po.setPet(this);
		isOwned = true;
		this.po = po;
	}

	public HelpfulMenace() {
		super();
		isOwned = false;
	}

	/*AI stuff*/
	public void makeActionChoice(){
		Ability a;
		/*will never be hostile; will always either follow avatar (if owned), go where avatar directs it (if mounted)
		attack in vicinity, or go after treasure*/
		double rand = RandomlyGenerate.probability();
		
		
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
		Direction randDir = RandomlyGenerate.direction();
		return new Move(this, randDir, getMovementSpeed());
		//can pickup item on tile
		//will race around looking for treasure. OR check neighboring tiles (hexlocation get neighborhood)
		//check neighborhood for item. If there is an item in surrounding area, walk onto that tile
		//if there are no tiles, just move in a random direction.
	}
	
	protected void becomePet(PetOwnership po){
		po.setPet(this);
		this.po = po;
		
	}

}
