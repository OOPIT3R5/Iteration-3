package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;

public abstract class Ability {
	
	protected ArrayList<Entity> targetList;

	public Ability(ArrayList<Entity> targetList) {
		this.setTargetList(targetList);
	}
	
	abstract void execute();

	protected ArrayList<Entity> getTargetList() {
		return targetList;
	}

	protected void setTargetList(ArrayList<Entity> targetList) {
		this.targetList = targetList;
	}

}
