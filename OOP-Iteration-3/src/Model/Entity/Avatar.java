package Model.Entity;

import java.awt.Graphics;
import java.io.IOException;

import Model.Map.HexagonalLocation;
import Model.Map.Location;
import View.AvatarView;
import View.Model.MapObjectView;

public class Avatar extends Entity{
    AvatarView avatarView;
    
   
	public Avatar(){
		super.setLocation(new HexagonalLocation(0 , 0));
		avatarView = new AvatarView(this);
	}

	public Avatar(String name) {
		super(name);
		super.setLocation(new HexagonalLocation(0 , 0));
		avatarView = new AvatarView(this);

	}

	public Avatar(String name, Occupation o){
		super(name, o);
		avatarView = new AvatarView(this);

	}

    @Override
	public String dialogue() {
		// TODO Auto-generated method stub
		return "I'm the hero character";
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
	public void onTouch(Entity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override

	public void performAction() {
		// TODO Auto-generated method stub
	}

	@Override
    public void removeFromMap(){
    	
    }

	@Override
	public void render(Graphics g, HexagonalLocation center) {
		try {
			avatarView.render(g, center, this.getDirectionFacing(), this.getLocation(), this.getStatistics().getLife(), this.getStatistics().getMaxLife());
		} catch (IOException e) {
			e.printStackTrace();
		}		

	}

	@Override
	protected void render(Graphics g, HexagonalLocation center,
			Location location) {
		// TODO Auto-generated method stub
		
	}
	


	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("avatar,");
		builder.append("ITEMS,");
		builder.append(super.getActualInventory().toString());
		builder.append("STATS,");
		builder.append(super.getStatistics().toString());
		builder.append("LOCATION,");
		builder.append(super.getLocation().toString());
		return builder.toString();
	}
	
		
		
	
}
