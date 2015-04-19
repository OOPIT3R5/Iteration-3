package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Map.Grid.Tile.Tile;

public abstract class SummonerAbility extends SkillAbility{
	protected abstract int getRequiredMana();
	protected abstract int scaleMagnitude();
	protected abstract void cast();		// cast spell if there is enough mana
	protected abstract ArrayList<Tile> getTargetTiles();
	
	protected void useMana(Entity sourceEntity){
		//sourceEntity.useMana(getRequiredMana());
	}
}
