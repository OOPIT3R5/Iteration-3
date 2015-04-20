package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.TakeableItemVisitor;
import Model.SaveSystem.Saver;
import View.Model.MapObjectView;

public class SneakWeaponItem extends WeaponItem{
    public SneakWeaponItem(int statchange, String name, MapObjectView mov) {
        super(AttackSpeed.FAST, statchange, name, mov);
    }

    @Override
    public boolean isTwoHanded() {
        return true; //Assuming all sneak weapons are 2-handed
    }

    @Override
    public void accept(TakeableItemVisitor eiv) {
        eiv.visit(this);
    }

	@Override
	public void save(Saver saver) {
		// TODO Auto-generated method stub
		
	}
}
