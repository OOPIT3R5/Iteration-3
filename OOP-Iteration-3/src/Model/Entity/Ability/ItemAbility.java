package Model.Entity.Ability;

import Model.Entity.Entity;

public abstract class ItemAbility extends Ability {
    private Entity entity;

    public ItemAbility(Entity entity){
        this.entity = entity;
    }

    public ItemAbility() {
    }

    @Override
    protected Entity getSourceEntity() {
        return entity;
    }

    public void setEntity(Entity e){
        this.entity = e;
    }
}
