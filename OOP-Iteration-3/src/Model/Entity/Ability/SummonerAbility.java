package Model.Entity.Ability;

import Model.Entity.Entity;

public abstract class SummonerAbility extends MultipleTargetAbility{
	protected abstract int getRequiredMana();
	protected abstract void scaleMagnitude();
	protected abstract void cast();		// cast spell if there is enough mana
	
	protected void useMana(Entity sourceEntity){
		//sourceEntity.useMana(getRequiredMana());
	}
}
