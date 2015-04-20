package Model.Entity.Ability;

import Model.Entity.Entity;

public abstract class SummonerAbility extends SkillAbility{
	public abstract void cast();		// cast spell if there is enough mana
	public abstract int getRequiredMana();
	protected abstract int scaleMagnitude();
	
	protected void useMana(Entity sourceEntity){
		sourceEntity.checkMana(this);
	}
}
