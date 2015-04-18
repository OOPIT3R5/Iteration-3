package Model.Items;

import Model.Entity.Entity;

public interface MapObject {
    boolean isPassable();
    void onTouch(Entity entity);
}
