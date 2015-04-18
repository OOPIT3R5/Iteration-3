package Model.Items;

import Model.Entity.Entity;
import View.MapObjectView;

public interface MapObject {
    boolean isPassable();

    void onTouch(Entity entity);

    MapObjectView getMapObjectView();
}