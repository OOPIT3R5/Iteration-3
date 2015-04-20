package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.TakeableItemVisitor;
import Model.SaveSystem.Saver;
import View.Model.MapObjectView;

public class SmasherShieldOffHandItem extends OffHandItem{
    public SmasherShieldOffHandItem(int statchange, String name, MapObjectView mov) {
        super(statchange, name, mov);
    }

    public void accept(TakeableItemVisitor eiv){
        eiv.visit(this);
    }

	@Override
	public void save(Saver saver) {
		// TODO Auto-generated method stub
		
	}
}
