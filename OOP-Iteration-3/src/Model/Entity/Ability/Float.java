package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Map.Grid.Tile.Tile;

public class Float extends SummonerAbility {		// TODO Float class

	public Float(ArrayList<Tile> targetList, Entity entity) {
        
    }

	@Override
    public void execute() {
		
	}

	@Override
	public int getSkillLevel() {
		return 0;
	}

	@Override
	public int getRequiredMana() {
		return 0;
	}

	@Override
	public void cast() {
		
	}

	protected ArrayList<Tile> getTargetTiles() {
		return null;
	}

	@Override
	protected Entity getSourceEntity() {
		return null;
	}

	@Override
	protected int scaleMagnitude() {
		return 0;
	}

}
