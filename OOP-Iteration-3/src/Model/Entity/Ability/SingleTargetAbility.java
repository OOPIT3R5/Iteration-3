package Model.Entity.Ability;

import Model.Map.Grid.Tile.Tile;

public abstract class SingleTargetAbility extends SkillAbility{
	public abstract Tile getTargetTile();
}