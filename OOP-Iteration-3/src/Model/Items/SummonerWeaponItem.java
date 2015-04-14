package Model.Items;

public class SummonerWeaponItem extends WeaponItem {
    @Override
    public boolean isTwoHanded() {
        return false;//Summoner weapon items are always two-handed.
    }
}
