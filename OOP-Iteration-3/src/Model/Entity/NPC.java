package Model.Entity;

import java.util.ArrayList;

import Model.Map.Direction;
import Model.Map.GameMap;
import Model.Map.HexagonalLocation;
import Model.Map.Grid.Tile.Tile;
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

	public boolean avatarIsWithinRange(int range){
		ArrayList<HexagonalLocation> a = HexagonalLocation.circle(getLocation(), range);
		Avatar av = getAvatarOffMap();
		for(int i=0; i<a.size(); i++){
			
			if(av.getLocation() == a.get(i)){
				return true;
			}
			
		}
		return false;
	}

	public Direction directionTowardAvatar() {
		//ArrayList<Entity> e = getSurroundingEntities();
		Avatar a = getAvatarOffMap();
		int EU = getLocation().getU();
		int EV = getLocation().getV();
		
		int AU = a.getLocation().getU();
		int AV = a.getLocation().getV();
		
		
		if ((AU-EU)==0){
			if ((AV-EV)<0){
				return Direction.NORTH;
			}
			return Direction.SOUTH;
		}
		else if (AU<EU){
			if (AV>EV){
				return Direction.SOUTHWEST;
			}
		return Direction.NORTHWEST;
		}
		
		else if (AU>EU){
			if (AV<EV){
				return Direction.NORTHEAST;
			}
		}
		return Direction.SOUTHEAST;

	}

	
	private Avatar getAvatarOffMap() {
		return getMap().getAvatar();
	}

	public void becomeHostile() {
		hostility.becomeHostile();
	}
	
	public void becomeNonHostile() {
		hostility.becomeNonHostile();
	}
	
	public void provoke(){
		double rand = RandomlyGenerate.probability();
		if (rand>.10){
			becomeHostile();
		}
	}

	public GameMap getMap() {
		return map;
	}
	
	public void sleep() {
	}
	
	public void charm() {
		becomeNonHostile();
	}

	public void polymorph() {		// TODO enchantment spell methods
	}
	

}
