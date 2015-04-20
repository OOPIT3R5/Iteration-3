package Model.Map.AreaEffects;

import java.awt.Graphics;

import Model.Entity.Entity;
import Model.Entity.Ability.Ability;
import Model.Items.MapObject;
import Model.Map.HexagonalLocation;
import Model.Map.Location;
import View.Model.MapObjectView;

public class AreaEffect extends MapObject{
	private Ability ability;
	private MapObjectView mov;
	   
	public AreaEffect(Ability ability, MapObjectView mov){
		this.ability = ability;
		this.mov = mov;
	}
	
	public boolean isPassable(){
		return true;
	}
	
	public void onTouch(Entity e){
		ability.execute();
	}

	@Override
	public MapObjectView getMapObjectView() {
		return mov;
	}

	@Override
	protected void render(Graphics g, HexagonalLocation center,
			Location location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return ability.toString();
	}
}
