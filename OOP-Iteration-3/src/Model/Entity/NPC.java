package Model.Entity;

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

import Model.Map.Direction;
import Model.Map.GameMap;
import Model.Map.HexagonalLocation;
import Model.Map.Grid.Tile.Tile;
import Utility.RandomlyGenerate;
import View.NpcView;

public class NPC extends Entity {

	private NpcView npcView;
	protected Hostility hostility;
	public NPC(){
		super();
		npcView = new NpcView();
		hostility = new Hostility(this);
	}
	
	public NPC(String name, Occupation o) {
		super(name, o);
		npcView = new NpcView();

		hostility = new Hostility(this);
	}

	public NPC(String name) {
		super(name);
		npcView = new NpcView();

		hostility = new Hostility(this);
	}

	/*AI stuff*/
	public void performAction(){
		makeActionChoice();
	}
	
	public void makeActionChoice(){
		hostility.act();
	}

	public boolean avatarIsWithinRange(int range){
		ArrayList<HexagonalLocation> a = HexagonalLocation.circle(getLocation(), range);
		Avatar av = getMap().getAvatar();
		for(int i=0; i<a.size(); i++){
			if((av.getLocation().getU() == a.get(i).getU())&&(av.getLocation().getV() == a.get(i).getV())){
				return true;
			}
			
		}
		System.out.print("");
		return false;
	}

	public Direction directionTowardAvatar() {
		//ArrayList<Entity> e = getSurroundingEntities();
		Avatar a = getMap().getAvatar();
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
		becomeNonHostile();
	}
	
	public void charm() {
		becomeNonHostile();
	}

	public void polymorph() {		// TODO change image to sheep
		
	}
	
	public void unpolymorph(){		// TODO change to default image
		
	}

	@Override
	public void render(Graphics g, HexagonalLocation center) {
		try {
			npcView.render(g, center, this.getDirectionFacing(), this.getLocation(), this.getStatistics().getLife(), this.getStatistics().getMaxLife());
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	

}
