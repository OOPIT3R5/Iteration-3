package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.EquippableItemVisitor;

public class SummonerWeaponItem extends WeaponItem {

    SummonerWeaponItem(int statchange, Ability ability, String name) {
        super(AttackSpeed.SLOW, statchange, ability, name);
    }

    public void accept(EquippableItemVisitor eiv){
        eiv.visit(this);
    }

    @Override
    public boolean isTwoHanded() {
        return false;//Summoner weapon items are always two-handed.
    }
}
