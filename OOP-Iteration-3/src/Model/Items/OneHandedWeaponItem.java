package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.TakeableItemVisitor;
import Model.SaveSystem.Saver;
import View.Model.MapObjectView;

public class OneHandedWeaponItem extends SmasherWeaponItem {

    public OneHandedWeaponItem(int statchange, String name, MapObjectView mov) {
        super(AttackSpeed.MEDIUM, statchange, name, mov);
    }

    public void accept(TakeableItemVisitor eiv){
        eiv.visit(this);
    }

    @Override
    public boolean isTwoHanded() {
        return false;//One handed sword, duh
    }

	@Override
	public void save(Saver saver) {
		// TODO Auto-generated method stub
		
	}
}
