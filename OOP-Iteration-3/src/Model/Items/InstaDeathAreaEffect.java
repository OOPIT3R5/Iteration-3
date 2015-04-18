package Model.Items;

import Model.Entity.Entity;
import View.MapObjectView;

public class InstaDeathAreaEffect extends AreaEffect {
    public InstaDeathAreaEffect(MapObjectView mov) {
        super(mov);
    }

    @Override
    public void onTouch(Entity entity) {
        entity.changeHealth(-99999999); //Blast that loser.
    }
}
