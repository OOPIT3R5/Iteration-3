package Model.Items;

import Model.Entity.Entity;

public class AreaEffect implements MapObject {

    @Override
    public boolean isPassable() {
        return true;
    }

    @Override
    public void onTouch(Entity entity) {

    }
}
