package Model.Items;

import Model.Entity.Entity;

public class LevelUpAreaEffect extends AreaEffect {


    @Override
    public void onTouch(Entity entity) {
       entity.autoLevelUp();
    }
}
