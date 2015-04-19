package Model.Items;

import Model.Entity.TakeableItemVisitor;
import View.Model.MapObjectView;

public class SummonerTomeOffHandItem extends OffHandItem{
    public SummonerTomeOffHandItem(int statchange, String name, MapObjectView mov) {
        super(statchange, name, mov);
    }

    public void accept(TakeableItemVisitor eiv){
        eiv.visit(this);
    }
}
