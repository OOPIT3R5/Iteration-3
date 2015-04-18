package Model.Entity;

import java.util.ArrayList;

import Model.Entity.Ability.Move;

public class Hostility {
	
	/*REPLACE DIRECTIONPLACEHOLDER PLEASE!!!!!!!!*/
	ArrayList<Entity> directionPlaceholder;
	boolean isHostile;
	NPC npc;
	
	public Hostility() {
		isHostile = false;
	}
	public Hostility(NPC npc) {
		this.npc = npc;
	}
	
	/*CHANGE IN DESIGN!!! instead of hostility being an abstract
	 * class with subclasses deciding if it's hostile or nonhostile.
	 * We have one hostility class and use if statements/conditional logic.
	 * This does not break oo principles because hostility is a complete subsystem
	 * meaning the open closed principle isn't effected. Moreover, the 
	 *  */
	public void act() {
		
		Move m = new Move(directionPlaceholder, null, npc.getMovementSpeed());
		
		
	}

}
