package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Map.Grid.Tile.Tile;

public abstract class SummonerAbility extends SkillAbility{

	public SummonerAbility(ArrayList<Tile> targetList) {
		super(targetList);
	}

}
