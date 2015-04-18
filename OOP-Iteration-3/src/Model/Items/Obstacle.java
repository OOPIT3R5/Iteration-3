package Model.Items;

import Model.Entity.Ability.*;
import Model.Entity.Entity;
import View.MapObjectView;

public class Obstacle extends Item{

    public Obstacle(String name, MapObjectView mov) {
        super(new DoNothing(), name, mov);
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
    public void execute() {
        throw new RuntimeException("Should not have an Obstacle be ran.");
    }
}
