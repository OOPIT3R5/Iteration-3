package Model.Items;

import Model.Entity.TakeableItemVisitor;
import Model.SaveSystem.Saver;
import View.Model.MapObjectView;

public class ArmorItem extends EquippableItem{
    public ArmorItem(int statchange, String name, MapObjectView mov) {
        super(statchange, name, mov);
    }

    @Override
	public void accept(TakeableItemVisitor eiv){
        eiv.visit(this);
    }

	@Override
	public void save(Saver saver) {
		// TODO Auto-generated method stub
		
	}
}
