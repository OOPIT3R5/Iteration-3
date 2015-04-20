package Model.Items;

import Model.Entity.Entity;
import Model.SaveSystem.Saver;
import View.Model.MapObjectView;

public class Obstacle extends Item{

    public Obstacle(String name, MapObjectView mov) {
        super(name, mov);
    }

    @Override
    public boolean isPassable() {
        return false;   //Obstacles cannot be walked through
    }

    @Override
    public void onTouch(Entity entity) {
        throw new RuntimeException("Should not have an Obstacle be touched.");
    }

	@Override
	public void save(Saver saver) {
		// TODO Auto-generated method stub
		
	}
}
