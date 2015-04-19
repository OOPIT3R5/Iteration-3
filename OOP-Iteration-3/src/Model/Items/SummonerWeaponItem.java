package Model.Items;

import Model.Entity.TakeableItemVisitor;
import View.Model.MapObjectView;

public class SummonerWeaponItem extends WeaponItem {

    public SummonerWeaponItem(int statchange, String name, MapObjectView mov) {
        super(AttackSpeed.SLOW, statchange, name, mov);
    }

    public void accept(TakeableItemVisitor eiv){
        eiv.visit(this);
    }

    @Override
    public boolean isTwoHanded() {
        return false;//Summoner weapon items are always two-handed.
    }
}
