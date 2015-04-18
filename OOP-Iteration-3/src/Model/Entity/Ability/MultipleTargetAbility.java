package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Map.Grid.Tile.Tile;

public abstract class MultipleTargetAbility extends SkillAbility{
	protected abstract ArrayList<Tile> getTargetTiles();
}
