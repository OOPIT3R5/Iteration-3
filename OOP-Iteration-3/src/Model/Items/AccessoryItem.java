package Model.Items;

import Model.Entity.TakeableItemVisitor;
import Model.SaveSystem.Saver;
import View.Model.MapObjectView;

public class AccessoryItem extends EquippableItem {
    public AccessoryItem(int statchange, String name, MapObjectView mov) {
        super(statchange, name, mov);
    }

    public void accept(TakeableItemVisitor eiv){
        eiv.visit(this);
    }

<<<<<<< HEAD
	
=======
	@Override
	public void save(Saver saver) {
		// TODO Auto-generated method stub
		
	}
>>>>>>> 5ebb19387e3924a893f299560c7175621cf9902b
}
