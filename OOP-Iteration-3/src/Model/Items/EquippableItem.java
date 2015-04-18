package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.EquippableItemVisitor;
import View.MapObjectView;

public abstract class EquippableItem extends TakeableItem {

    private int statchange;

    public EquippableItem(int statchange, Ability ability, String name, MapObjectView mov) {
        super(ability, name, mov);
        this.statchange = statchange;
    }

    public int getStatChangingValue(){
        return statchange;
    }

    public abstract void accept(EquippableItemVisitor eiv);
}
