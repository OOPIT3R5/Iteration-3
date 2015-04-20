package Model.Map.AreaEffects;

import Model.Entity.Entity;
import Model.Entity.Ability.Ability;

public class AreaEffect {
	private Ability ability;
	
	public AreaEffect(Ability ability){
		this.ability = ability;
	}
	
	public boolean isPassable(){
		return true;
	}
	
	public void onTouch(Entity e){
		ability.execute();
	}
}
