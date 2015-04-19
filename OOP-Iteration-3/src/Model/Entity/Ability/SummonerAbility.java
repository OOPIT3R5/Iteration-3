package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Map.Grid.Tile.Tile;

public abstract class SummonerAbility extends SkillAbility{
	public abstract int getRequiredMana();
	protected abstract int scaleMagnitude();
	public abstract void cast();		// cast spell if there is enough mana
	
	protected void useMana(Entity sourceEntity){
		sourceEntity.useMana(this);
	}
}
