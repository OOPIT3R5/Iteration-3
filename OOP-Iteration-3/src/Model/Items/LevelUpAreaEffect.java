package Model.Items;

import Model.Entity.Entity;
import View.Model.MapObjectView;

public class LevelUpAreaEffect extends AreaEffect {


    public LevelUpAreaEffect(MapObjectView mov) {
        super(mov);
    }

    @Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public void onTouch(Entity entity) {
       entity.autoLevelUp();
    }

	
}
