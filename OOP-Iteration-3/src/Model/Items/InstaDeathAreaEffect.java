package Model.Items;

import Model.Entity.Entity;

public class InstaDeathAreaEffect extends AreaEffect {
    @Override
    public void onTouch(Entity entity) {
        entity.changeHealth(-99999999); //Blast that loser.
    }
}
