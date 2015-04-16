package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;

public abstract class Ability {
	
	private ArrayList<Entity> targetList;

	public Ability(ArrayList<Entity> targetList) {
		this.setTargetList(targetList);
	}
	
	abstract void execute();

	private ArrayList<Entity> getTargetList() {
		return targetList;
	}

	private void setTargetList(ArrayList<Entity> targetList) {
		this.targetList = targetList;
	}

}
