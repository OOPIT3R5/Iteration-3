package Model.Entity;

import java.util.ArrayList;

import Utility.*;
import Model.Entity.Ability.Ability;
import Model.Entity.Ability.Attack;
import Model.Entity.Ability.DoNothing;
import Model.Entity.Ability.Move;
import Model.Map.Direction;

public class Hostility {
	
	/*REPLACE DIRECTIONPLACEHOLDER PLEASE!!!!!!!! 
	 * I DON'T KNOW WHY THE DIRECTION IS AN ENITY LIST EITHER
	 * I WAS TOLD THE PARAMETER FOR MOVE SHOULD BE/WAS DRECTION
	 * THIS CONFUSES ME. caps lock was on and I don't want to bother re-writing so deal*/
	ArrayList<Entity> entityListPlaceholder;
	Direction directionPlaceholder;
	
	RandomGenerator randomlyGenerate = new RandomGenerator();	
	boolean isHostile;
	NPC npc;
	
	public Hostility() {
		isHostile = false;
	}
	
	public Hostility(boolean hostility) {
		this();
		setHostility(hostility);
	}
	
	public Hostility(NPC npc) {
		this();
		this.npc = npc;
	}
	
	public Hostility(NPC npc, boolean hostility) {
		this(npc);
		setHostility(hostility);
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
	 *  Main reason for design change was that previous design was in conflict with 
	 *  how abilities work/were designed.*/
	public void act() {
		if(isHostile){
			hostileAct();
		}
		nonHostileAct();		
	}
	
	/*Hostile entities are likely to attack the avatar.
	 * They will also have a higher probability of
	 *  moving toward the avatar (if it is possible)*/
	
	public void hostileAct(){
		double prob = randomlyGenerate.probability();	
		Ability a;
		Direction TowardAvatarDirectionPlaceholder = null;
		
		if (npc.avatarIsWithinRange()){
			a = new Attack(null, null);//attack in avatar direction
		}
		else{
			if (prob < .60){
				//60% chance of moving toward avatar
				a = new Move(npc, TowardAvatarDirectionPlaceholder, npc.getMovementSpeed());
			}
			else if (prob < .90){
				//30% chance of moving in random direction
				a = new Move(npc, randomlyGenerate.direction(), npc.getMovementSpeed());
			}
			else {
				//10% chance of doing nothing
				a = new DoNothing();
			}
		}
		a.execute();
			
	}

	
	/*non-hostile npcs will not attack the avatar.
	 * They more or less just move around the map*/
	public void nonHostileAct(){
		//50% change of moving
		if(randomlyGenerate.probability()>.5){
			//randomly generate a direction to move in, and move in that direction.
			Direction d = randomlyGenerate.direction();
		}
		Ability a = new DoNothing();
		//if you don't move, then you [currently do nothing]
	}

	
	public void setHostility(boolean ishostile){
		isHostile = ishostile;
	}
	
	

}
