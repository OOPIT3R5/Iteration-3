package Model.Entity;

import java.util.ArrayList;
import java.util.Random;

import Model.Entity.Ability.Move;

public class Hostility {
	
	/*REPLACE DIRECTIONPLACEHOLDER PLEASE!!!!!!!! 
	 * I DON'T KNOW WHY THE DIRECTION IS AN ENITY LIST EITHER
	 * I WAS TOLD THE PARAMETER FOR MOVE SHOULD BE/WAS DRECTION
	 * THIS CONFUSES ME. caps lock was on and I don't want to bother re-writing so deal*/
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
	 * meaning the open closed principle isn't effected. I had a list of principles I had
	 * thought it would violate but I can't remember any right now beyond open-closed.
	 * All I know is that I was able to justify why this design wasn't breaking them
	 * if I can find anything it's breaking I'll re-think the design then.
	 * 
	 *  Main reason for design change was that previous design was in conflict with how abilities work*/
	public void act() {
		double prob = genRandProbability();
		
		if(isHostile){
			hostileAct(prob);
		}
		nonHostileAct(prob);		
		
	}
	
	/*Hostile entities are likely to attack the avatar.
	 * They will also have a higher probability of
	 *  moving toward the avatar (if it is possible)*/
	
	public void hostileAct(double prob){
		Move m = new Move(npc, null, npc.getMovementSpeed());
	}
	
	/*non-hostile npcs will not attack the avatar.
	 * They more or less just move around the map*/
	public void nonHostileAct(double prob){
		Move m = new Move(npc, null, npc.getMovementSpeed());
	}
	
	private double genRandProbability(){
		
		Random random = new Random();
		return random.nextDouble();
		
	}

}
