package Model.Items;

import Model.Entity.Entity;
import View.MapObjectView;

public class LevelUpAreaEffect extends AreaEffect {


    public LevelUpAreaEffect(MapObjectView mov) {
        super(mov);
    }

    @Override
    public void onTouch(Entity entity) {
       entity.autoLevelUp();
    }
}
