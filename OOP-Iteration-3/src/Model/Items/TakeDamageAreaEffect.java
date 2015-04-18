package Model.Items;

import Model.Entity.Entity;

public class TakeDamageAreaEffect extends AreaEffect{

    private int damage;

    public TakeDamageAreaEffect(int damage){
        this.damage = damage;
    }

    @Override
    public void onTouch(Entity entity) {
        entity.changeHealth(-1*damage);
    }
}
