package Tests;

import java.util.*;

import Model.Entity.*;
import Model.Entity.Ability.Move;
import Model.Map.Direction;
import Model.Map.GameMap;
import Utility.RandomlyGenerate;



public class entityandAvatarTests {
	static GameMap gm;
	static Avatar avatar;
	public static void main(String[] args){
		RandomlyGenerate r = new RandomlyGenerate();
		avatarCreation();
		monsterMovement();
		//helpfulMenace();
		//troublesomeMenace();
		//horse();
		//mountHelpfulMenace();
	}

	

	private static void mountHelpfulMenace() {
		Avatar avatar = new Avatar("bob");
		new Smasher(avatar);
		avatar.getOccupationTestMethod();
		Pet pet = new HelpfulMenace();
		PetOwnership po = new PetOwnership(avatar, pet);
		
		((Mount)pet).mount(avatar);
		for(int i=0; i<10; i++){
			((NPC) pet).makeActionChoice();
		}
	}



	private static void horse() {
		
		//TODO
	}



	private static void troublesomeMenace() {
		Avatar avatar = new Avatar("bob");
		new Smasher(avatar);
		avatar.getOccupationTestMethod();
		Pet pet = new TroublesomeMenace();
		PetOwnership po = new PetOwnership(avatar, pet);
		
		for(int i=0; i<10; i++){
			((NPC) pet).makeActionChoice();
		}
	}

	
	private static void helpfulMenace() {
		Avatar avatar = new Avatar("bob");
		new Smasher(avatar);
		avatar.getOccupationTestMethod();
		Pet pet = new HelpfulMenace();
		PetOwnership po = new PetOwnership(avatar, pet);
		
		for(int i=0; i<10; i++){
			((NPC) pet).makeActionChoice();
		}
	}


	private static void monsterMovement(){
		NPC npc = new Monster();
		gm.addEntity(3, 1, npc);
		npc.setMap(gm);
		for(int i=0; i<10; i++){
			mockAvatarMovement();
			npc.performAction();
		}
		
	}
	
	private static void mockAvatarMovement() {
		
		Move m = new Move(avatar, gm, Direction.NORTHEAST, 1);
		
	}



	private static void avatarCreation() {
		Scanner s = new Scanner (System.in);
		System.out.println("Enter Avatar Name: ");
		String name = s.next();
		
		avatar = new Avatar(name);
		System.out.println("Enter Occupation number: ");		
		int occupation = s.nextInt();
		Occupation o;
		if(occupation == 1){
			o = new Summoner(avatar);
		}
		if(occupation == 2){
			o = new Sneak(avatar);
		}
		else{
			o= new Smasher(avatar);
		}
		gm = new GameMap(31, 31, avatar);
		avatar.setMap(gm);
		System.out.println(avatar.toString());
		
	}

}
