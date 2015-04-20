package Model.Items;

import java.awt.Graphics;

import Model.Entity.Entity;
import Model.Map.HexagonalLocation;
import Model.Map.Location;
import View.Model.MapObjectView;

public class HealDamageAreaEffect extends AreaEffect {

    private int heal;

    public HealDamageAreaEffect(int heal, MapObjectView mov){
        super(mov);
        this.heal = heal;
    }

    @Override
    public void onTouch(Entity entity) {
        entity.changeHealth(heal);
    }

	
}
