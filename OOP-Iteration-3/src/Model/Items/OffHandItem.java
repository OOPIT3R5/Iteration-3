package Model.Items;

import View.Model.MapObjectView;

public abstract class OffHandItem extends EquippableItem{
    public OffHandItem(int statchange,String name, MapObjectView mov) {
        super(statchange, name, mov);
    }
}
