package Model.Items;

import Model.Entity.Entity;
import Model.Entity.TakeableItemVisitor;
import Model.Entity.Ability.ItemAbility;
import Model.SaveSystem.Saver;
import View.Model.MapObjectView;

public class UsableItem extends TakeableItem{
    Entity avatar;
    private ItemAbility ability;

    public UsableItem(ItemAbility ability, String name, MapObjectView mov) {
        super(name, mov);
        this.ability = ability;
    }

    public UsableItem(ItemAbility ability, String name, MapObjectView mov, Entity entity){
        super(name, mov);
        this.ability = ability;
        this.avatar = entity;
    }

    @Override
    public void accept(TakeableItemVisitor eiv) {
        eiv.visit(this);
    }

    public void execute() {
        ability.setEntity(avatar);
        ability.execute();
    }

    @Override
    public boolean isPassable() {
        return true;
    }

    @Override
    public void onTouch(Entity entity){
        avatar = entity;
        avatar.addToInventory(this);
    }

	@Override
	public void save(Saver saver) {
		// TODO Auto-generated method stub
		
	}
}
