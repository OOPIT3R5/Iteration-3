package Model.Items;

import Model.Entity.Entity;
import View.Model.MapObjectView;

public class TakeDamageAreaEffect extends AreaEffect{

    private int damage;

    public TakeDamageAreaEffect(int damage, MapObjectView mov){
        super(mov);
        this.damage = damage;
    }

    @Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public void onTouch(Entity entity) {
        entity.changeHealth(-1*damage);
    }
}
