package Model.Items;

import java.awt.Graphics;

import Model.Entity.Entity;
import Model.Map.HexagonalLocation;
import Model.Map.Location;
import View.Model.MapObjectView;

public class LevelUpAreaEffect extends AreaEffect {


    public LevelUpAreaEffect(MapObjectView mov) {
        super(mov);
    }

    @Override
    public void onTouch(Entity entity) {
       entity.autoLevelUp();
    }

	
}
