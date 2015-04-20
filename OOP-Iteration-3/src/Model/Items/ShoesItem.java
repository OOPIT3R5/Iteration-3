package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.TakeableItemVisitor;
import Model.SaveSystem.Saver;
import View.Model.MapObjectView;

public class ShoesItem extends EquippableItem {
    public ShoesItem(int statchange, String name, MapObjectView mov) {
        super(statchange, name, mov);
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
