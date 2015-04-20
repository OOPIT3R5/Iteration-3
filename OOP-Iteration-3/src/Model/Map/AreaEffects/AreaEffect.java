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
	
	@Override
	public MapObjectView getMapObjectView() {
		return mov;
	}
	
	@Override
	public String getName() {
		return ability.toString();
	}

	@Override
	public boolean isPassable(){
		return true;
	}

	@Override
	public void onTouch(Entity e){
		ability.execute();
	}

	@Override
	protected void render(Graphics g, HexagonalLocation center,
			Location location) {
		// TODO Auto-generated method stub
		
	}
}
