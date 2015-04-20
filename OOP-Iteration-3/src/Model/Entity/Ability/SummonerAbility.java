package Model.Entity.Ability;

import Model.Entity.Entity;

public abstract class SummonerAbility extends SkillAbility{
	public abstract int getRequiredMana();
	protected abstract int scaleMagnitude();
	public abstract void cast();		// cast spell if there is enough mana
	
	protected void useMana(Entity sourceEntity){
		sourceEntity.checkMana(this);
	}
}
