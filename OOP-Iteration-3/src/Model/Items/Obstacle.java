package Model.Items;

public class Obstacle extends Item{

    @Override
    public boolean isPassable() {
        return false;   //Obstacles cannot be walked through
    }
}
