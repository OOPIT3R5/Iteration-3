package Model.Items;

import Model.Entity.Entity;
import View.Model.MapObjectView;

public class HealDamageAreaEffect extends AreaEffect {

    private int heal;

    public HealDamageAreaEffect(int heal, MapObjectView mov){
        super(mov);
        this.heal = heal;
    }

    @Override
	public String getName() {
		// TODO Auto-generated method stub
		return "HealDamageAreaEffect";
	}

	@Override
    public void onTouch(Entity entity) {
        entity.changeHealth(heal);
    }

	
}
