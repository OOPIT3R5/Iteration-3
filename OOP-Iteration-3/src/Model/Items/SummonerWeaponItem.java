package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.EquippableItemVisitor;
import View.MapObjectView;

public class SummonerWeaponItem extends WeaponItem {

    SummonerWeaponItem(int statchange, Ability ability, String name, MapObjectView mov) {
        super(AttackSpeed.SLOW, statchange, ability, name, mov);
    }

    public void accept(EquippableItemVisitor eiv){
        eiv.visit(this);
    }

    @Override
    public boolean isTwoHanded() {
        return false;//Summoner weapon items are always two-handed.
    }
}
