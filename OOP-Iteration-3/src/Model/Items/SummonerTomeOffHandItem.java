package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.EquippableItemVisitor;

public class SummonerTomeOffHandItem extends OffHandItem{
    public SummonerTomeOffHandItem(int statchange, Ability ability, String name) {
        super(statchange, ability, name);
    }

    public void accept(EquippableItemVisitor eiv){
        eiv.visit(this);
    }
}
