package Model.Entity;

import Model.Items.AccessoryItem;
import Model.Items.ArmorItem;
import Model.Items.BrawlingWeaponItem;
import Model.Items.OneHandedWeaponItem;
import Model.Items.ShoesItem;
import Model.Items.SmasherShieldOffHandItem;
import Model.Items.SneakWeaponItem;
import Model.Items.SummonerTomeOffHandItem;
import Model.Items.SummonerWeaponItem;
import Model.Items.TwoHandedWeaponItem;
import Model.Items.UsableItem;


public interface TakeableItemVisitor {

    void visit(AccessoryItem acci);
    //Visit methods for the rest (no restrictions... yet.
    void visit(ArmorItem ai);
    void visit(BrawlingWeaponItem bwi);

    //Visit methods for the specialized weapon items.
    void visit(OneHandedWeaponItem ohwi);
    void visit(ShoesItem si);

    void visit(SmasherShieldOffHandItem ssohi);
    void visit(SneakWeaponItem snewi);

    //Visit methods for the specialized off-hand items.
    void visit(SummonerTomeOffHandItem stohi);
    void visit(SummonerWeaponItem sumwi);
    void visit(TwoHandedWeaponItem thwi);

    void visit(UsableItem ui);
}
