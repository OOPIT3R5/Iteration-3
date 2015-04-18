package Model.Items;

import Model.Entity.Entity;
import View.MapObjectView;

public class TakeDamageAreaEffect extends AreaEffect{

    private int damage;

    public TakeDamageAreaEffect(int damage, MapObjectView mov){
        super(mov);
        this.damage = damage;
    }

    @Override
    public void onTouch(Entity entity) {
        entity.changeHealth(-1*damage);
    }
}
