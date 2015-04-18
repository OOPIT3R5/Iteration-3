package Model.Items;

import Model.Entity.Entity;

public class HealDamageAreaEffect extends AreaEffect {

    private int heal;

    public HealDamageAreaEffect(int heal){
        this.heal = heal;
    }

    @Override
    public void onTouch(Entity entity) {
        entity.changeHealth(heal);
    }
}
