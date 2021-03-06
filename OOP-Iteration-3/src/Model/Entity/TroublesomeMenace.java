package Model.Entity;

import java.util.ArrayList;

import Model.Entity.Ability.Ability;
import Model.Entity.Ability.Attack;
import Model.Entity.Ability.Move;
import Model.Map.Direction;
import Model.Map.HexagonalLocation;
import Utility.RandomlyGenerate;

public class TroublesomeMenace extends NonAdversarial implements Pet{

	PetOwnership po;
	boolean isOwned;
	
	public TroublesomeMenace() {
		super("TroubleSome Pet");
		isOwned = false;
		
	}

	public TroublesomeMenace(PetOwnership po) {
		super();
		po.setPet(this);
		isOwned = true;
		this.po = po;
	}

	@Override
	public Ability attackInVicinity() {
		return new Attack(this,this.getOccupation().getAttack());		// TODO doesn't do anything

		//find closest entity (not avatar), face, and attack

    }
	@Override
	public void becomePet(PetOwnership po){
		isOwned = true;
		this.po = po;
		
	}

	private Direction dirOfitemInSurroundingArea() {
		ArrayList<HexagonalLocation> a = HexagonalLocation.circle(getLocation(), 1);
		
		for(int i=0; i<a.size(); i++){
			if (getMap().getTile(a.get(i)).getMapObject() != null){
				return Direction.intToHex(i);
			}
		}
		return directionTowardAvatar();
	}
	
	/*AI stuff*/
	@Override
	public void makeActionChoice(){
		Ability a;
		/*will never be hostile; will always either follow avatar (if owned), go where avatar directs it (if mounted)
		attack in vicinity, or go after treasure*/
		double rand = RandomlyGenerate.probability();
		
		
		if(rand <.65 && isOwned){
			//65% chance of following (behind) avatar
			a = po.followAvatar();
			System.out.println("following behind avatar");
		}
		else if(rand<.85){
			//20% chance of going for adjacent/neighboring treasure
			a = stealInVicinity();
			//can pickup item on tile
			System.out.println("stealing nearby treasure or moving to random spot if no treasure nearby");
		}
		else if(rand <.95){
			//10% chance of attacking in a random direction
			a = attackInVicinity();//change this so that it returns an ability
			System.out.println("attacking in vicinity");
		}
		else{
			//5% chance of doing nothing
			//a = new DoNothing();
			a = po.followAvatar();
			System.out.println("doing nothing - I mean continuing to follow master");
		}
		try {
			a.execute();
		} catch (Exception e) {
			
		}
	}

	@Override
	public Ability stealInVicinity() {
		Direction Dir = dirOfitemInSurroundingArea();

		return new Move(this, Dir, getMovementSpeed());
		
		//check neighboring tiles (hexlocation get neighborhood)
		//check neighborhood for item. If there is an item in surrounding area, walk onto that tile
		//if there are no tiles, just move in a random direction.
	}


}
