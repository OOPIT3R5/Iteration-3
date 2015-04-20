package Model.Entity;

import java.awt.Graphics;
import java.io.IOException;
import java.util.Observer;

import Model.Map.HexagonalLocation;
import View.AvatarView;

public class Avatar extends Entity{
    AvatarView avatarView;
	public Avatar(){
		super.setLocation(new HexagonalLocation(0 , 0));
		avatarView = new AvatarView();
	}

	public Avatar(String name, Occupation o){
		super(name, o);
	}

	public Avatar(String name) {
		super(name);
		super.setLocation(new HexagonalLocation(0 , 0));
	}

    @Override
    public void removeFromMap(){
    	setChanged();
		notifyObservers();
    }

	@Override

	public void performAction() {
		// TODO Auto-generated method stub
	}
		
	public void render(Graphics g, HexagonalLocation center) {
		try {
			avatarView.render(g, center, this.getDirectionFacing(), this.getLocation(), this.getStatistics().getLife(), this.getStatistics().getMaxLife());
		} catch (IOException e) {
			e.printStackTrace();
		}		

	}
}
