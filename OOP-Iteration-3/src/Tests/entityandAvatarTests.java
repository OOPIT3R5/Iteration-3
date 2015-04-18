package Tests;

import java.util.*;

import Model.Entity.*;


public class entityandAvatarTests {
	public static void main(String[] args){
		avatarCreation();		
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
