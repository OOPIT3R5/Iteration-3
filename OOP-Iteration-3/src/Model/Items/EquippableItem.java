package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.EquippableItemVisitor;

public abstract class EquippableItem extends TakeableItem {

    private int statchange;

    public EquippableItem(int statchange, Ability ability, String name) {
        super(ability, name);
        this.statchange = statchange;
    }

    public int getStatChangingValue(){
        return statchange;
    }

    public abstract void accept(EquippableItemVisitor eiv);
}
