package Model.Entity;

import Model.Items.*;


public interface EquippableItemVisitor {

    //Visit methods for the specialized weapon items.
    void visit(SmasherWeaponItem smawi);
    void visit(SummonerWeaponItem sumwi);
    void visit(SneakWeaponItem snewi);

    //Visit methods for the specialized off-hand items.
    void visit(SummonerTomeOffHandItem stohi);
    void visit(SmasherShieldOffHandItem ssohi);

    //Visit methods for the rest (no restrictions... yet.
    void visit(ArmorItem ai);
    void visit(AccessoryItem acci);
    void visit(ShoesItem si);

}