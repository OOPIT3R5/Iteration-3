package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Map.Grid.Tile.Tile;

public class Attack extends SkillAbility{

	public Attack(ArrayList<Tile> targetList, Entity entity) {
        super(targetList, entity);
    }

	@Override
    public void execute() {
        
	}
}
