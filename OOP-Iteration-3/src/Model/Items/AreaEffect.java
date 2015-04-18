package Model.Items;

public abstract class AreaEffect implements MapObject {

    @Override
    public boolean isPassable() {
        return true;
    }
}
