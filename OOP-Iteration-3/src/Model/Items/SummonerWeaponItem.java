package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.TakeableItemVisitor;
import View.MapObjectView;

public class SummonerWeaponItem extends WeaponItem {

    public SummonerWeaponItem(int statchange, Ability ability, String name, MapObjectView mov) {
        super(AttackSpeed.SLOW, statchange, ability, name, mov);
    }

    public void accept(TakeableItemVisitor eiv){
        eiv.visit(this);
    }

    @Override
    public boolean isTwoHanded() {
        return false;//Summoner weapon items are always two-handed.
    }
}
