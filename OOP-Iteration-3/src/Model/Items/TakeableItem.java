package Model.Items;

public abstract class TakeableItem extends Item{

    //TODO: Override onTouch() method to go into Inventory of Entity.

    @Override
    public boolean isPassable(){
        return true;
    }
}
