package Model.Items;

import Model.Entity.Ability.Ability;

public class SummonerWeaponItem extends WeaponItem {

    SummonerWeaponItem(int statchange, Ability ability, String name) {
        super(AttackSpeed.SLOW, statchange, ability, name);
    }

    @Override
    public boolean isTwoHanded() {
        return false;//Summoner weapon items are always two-handed.
    }
}
