package Model.Items;

import Model.Entity.Ability.*;
import Model.Entity.Entity;

public class Obstacle extends Item{

    public Obstacle(String name) {
        super(new DoNothing(null), name);
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
    public void execute(Entity entity) {
        throw new RuntimeException("Should not have an Obstacle be ran.");
    }
}
