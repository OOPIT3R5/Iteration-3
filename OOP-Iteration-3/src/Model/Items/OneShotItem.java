package Model.Items;

import Model.Entity.Entity;
import Model.Entity.Ability.ItemAbility;
import Model.SaveSystem.Saver;
import View.Model.MapObjectView;

public class OneShotItem extends Item {

    private ItemAbility ability;

    public OneShotItem(ItemAbility ability, String name, MapObjectView mov) {
        super(name, mov);
        this.ability = ability;
    }

    @Override
    public boolean isPassable() {
        return true;
    }

    //TODO: Figure out the situation of triggering a OneShotItem.
    @Override
    public void onTouch(Entity entity) {
        ability.setEntity(entity);
        ability.execute();
    }

	@Override
	public void save(Saver saver) {
		// TODO Auto-generated method stub
		
	}
}
