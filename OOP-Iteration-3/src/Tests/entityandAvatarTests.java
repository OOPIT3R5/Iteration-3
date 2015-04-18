package Tests;

import java.util.*;

import Model.Entity.*;
import Utility.RandomlyGenerate;


public class entityandAvatarTests {

	public static void main(String[] args){
		RandomlyGenerate r = new RandomlyGenerate();
		//avatarCreation();
		//monsterMovement();
		helpfulMenace();
	}

	
	private static void helpfulMenace() {
		Entity avatar = new Avatar("bob");
		new Smasher(avatar);
		avatar.getOccupationTestMethod();
		Pet pet = new HelpfulMenace();
		PetOwnership po = new PetOwnership(avatar, pet);
		
		for(int i=0; i<10; i++){
			((NPC) pet).makeActionChoice();
		}
	}


	private static void monsterMovement(){
		Entity npc = new Monster();
		

		for(int i=0; i<10; i++){
			npc.makeActionChoice();
		}
	}
	private static void avatarCreation() {
		Scanner s = new Scanner (System.in);
		System.out.println("Enter Avatar Name: ");
		String name = s.next();
		
		Entity avatar = new Avatar(name);
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
		
		System.out.println(avatar.toString());
		
	}

}
