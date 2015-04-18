package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Map.Grid.Tile.Tile;

public abstract class SneakAbility extends SkillAbility{

	public SneakAbility(ArrayList<Tile> targetList, Entity entity) {
        super(targetList, entity);
    }

}
