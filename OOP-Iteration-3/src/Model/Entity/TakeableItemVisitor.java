package Model.Entity;

import Model.Items.*;


public interface TakeableItemVisitor {

    //Visit methods for the specialized weapon items.
    void visit(OneHandedWeaponItem ohwi);
    void visit(TwoHandedWeaponItem thwi);
    void visit(BrawlingWeaponItem bwi);

    void visit(SummonerWeaponItem sumwi);
    void visit(SneakWeaponItem snewi);

    //Visit methods for the specialized off-hand items.
    void visit(SummonerTomeOffHandItem stohi);
    void visit(SmasherShieldOffHandItem ssohi);

    //Visit methods for the rest (no restrictions... yet.
    void visit(ArmorItem ai);
    void visit(AccessoryItem acci);
    void visit(ShoesItem si);

    void visit(UsableItem ui);
}
