package Model.Items;

import java.awt.Graphics;

import Model.Map.HexagonalLocation;
import Model.Map.Location;
import View.Model.MapObjectView;

public abstract class AreaEffect implements MapObject {
    private MapObjectView mov;

    public AreaEffect(MapObjectView mov){
        this.mov = mov;
    }

    @Override
    public boolean isPassable() {
        return true;
    }

    @Override
    public MapObjectView getMapObjectView(){
        return mov;
    }

	@Override
	public void render(Graphics g, HexagonalLocation center, Location location) {
		// TODO Auto-generated method stub
		
	}
    
    
    
}
