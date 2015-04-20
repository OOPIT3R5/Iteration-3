package Model.Entity;

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

import Model.Entity.Ability.Ability;
import Model.Entity.Ability.Move;
import Model.Map.Direction;
import Model.Map.GameMap;
import Model.Map.HexagonalLocation;
import Model.Map.Location;
import Utility.RandomlyGenerate;
import View.NpcView;
import View.Model.MapObjectView;

public class NPC extends Entity {

	private NpcView npcView;
	protected Hostility hostility;
	protected boolean isfollowingEntity;
	
	public NPC(){
		super();
		npcView = new NpcView();
		hostility = new Hostility(this);
	}
	
	public NPC(String name) {
		super(name);
		npcView = new NpcView();

		hostility = new Hostility(this);
	}

	public NPC(String name, Occupation o) {
		super(name, o);
		npcView = new NpcView();

		hostility = new Hostility(this);
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
	public void becomeHostile() {
		hostility.becomeHostile();
	}
	public void becomeNonHostile() {
		hostility.becomeNonHostile();
	}


	public void charm() {
		becomeNonHostile();
	}

	@Override
	public String dialogue() {
		// TODO Auto-generated method stub
		return "I'm a nonplayable character";
	}


	public Direction directionTowardAvatar() {
		//ArrayList<Entity> e = getSurroundingEntities();
		Avatar a = getMap().getAvatar();
		int EU = getLocation().getU();
		int EV = getLocation().getV();
		
		int AU = a.getLocation().getU() + 1;
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
	
	public GameMap getMap() {
		return map;
	}
	
	@Override
	public MapObjectView getMapObjectView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean isPassable() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void makeActionChoice(){
		hostility.act();
	}

	@Override
	public void onTouch(Entity entity) {
		// TODO Auto-generated method stub
		
	}
	
	/*AI stuff*/
	@Override
	public void performAction(){
		if(isfollowingEntity){
			Avatar a = getMap().getAvatar();
			if (HexagonalLocation.rectilinearDistance(a.getLocation(), this.getLocation()) >= 2) {
				Ability m = new Move(this, directionTowardAvatar(), this.getMovementSpeed());
				m.execute();
			}
		}
		else{
			makeActionChoice();
		}
	}

	@Override
	public void polymorph() {		// TODO change image to sheep
		
	}

	public void provoke(){
		double rand = RandomlyGenerate.probability();
		if (rand>.10){
			becomeHostile();
		}
	}

	@Override
	public void render(Graphics g, HexagonalLocation center) {
		try {
			npcView.render(g, center, this.getDirectionFacing(), this.getLocation(), this.getStatistics().getLife(), this.getStatistics().getMaxLife());
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	@Override
	protected
	void render(Graphics g, HexagonalLocation center, Location location) {
		try {
			npcView.render(g,center, getDirectionFacing(), ((HexagonalLocation)location), stats.getLife() , stats.getMaxLife() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void setIfShouldFollowingEntity(boolean follow){
		isfollowingEntity = follow;
	}

	public void sleep() {
		becomeNonHostile();
	}

	public void unpolymorph(){		// TODO change to default image
		
	}
	

}
