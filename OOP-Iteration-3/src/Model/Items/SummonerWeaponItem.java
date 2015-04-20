package Model.Items;

import Model.Entity.TakeableItemVisitor;
import Model.SaveSystem.Saver;
import View.Model.MapObjectView;

public class SummonerWeaponItem extends WeaponItem {

    public SummonerWeaponItem(int statchange, String name, MapObjectView mov) {
        super(AttackSpeed.SLOW, statchange, name, mov);
    }

    @Override
	public void accept(TakeableItemVisitor eiv){
        eiv.visit(this);
    }

    @Override
    public boolean isTwoHanded() {
        return false;//Summoner weapon items are always two-handed.
    }

	@Override
	public void save(Saver saver) {
		// TODO Auto-generated method stub
		
	}
}
