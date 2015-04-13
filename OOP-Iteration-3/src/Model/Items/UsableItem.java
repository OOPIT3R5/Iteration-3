package Model.Items;

public class UsableItem extends TakeableItem{
    @Override
    public boolean isPassable() {
        return true;
    }
}
