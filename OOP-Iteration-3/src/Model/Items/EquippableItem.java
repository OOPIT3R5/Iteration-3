package Model.Items;

import View.Model.MapObjectView;

public abstract class EquippableItem extends TakeableItem {

    private int statchange;

    public EquippableItem(int statchange, String name, MapObjectView mov) {
        super(name, mov);
        this.statchange = statchange;
    }

    public int getStatChangingValue(){
        return statchange;
    }

}
