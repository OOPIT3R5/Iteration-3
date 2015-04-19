package Model.Items;

import View.Model.MapObjectView;

public abstract class AreaEffect implements MapObject {
    private MapObjectView mov;

    public AreaEffect(MapObjectView mov){
        this.mov = mov;
    }

    @Override
    public boolean isPassable() {
        return true;
    }

    @Override
    public MapObjectView getMapObjectView(){
        return mov;
    }
}
