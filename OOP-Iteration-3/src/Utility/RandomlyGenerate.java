package Utility;

import java.util.Random;

import Model.Map.Direction;

public final class RandomlyGenerate {
	public static Direction direction() {
		double r = probability();
		
		if(r<.175){
			return Direction.NORTH;
		}
		else if(r<.35){
			return Direction.NORTHEAST;
		}
		else if(r<.525){
			return Direction.NORTHWEST;
		}
		else if(r<.7){
			return Direction.SOUTH;
		}
		else if(r<.875){
			return Direction.SOUTHEAST;
		}
		return Direction.SOUTHWEST;
	}
	
	public static double probability(){
		return random.nextDouble();		// TODO causing null-pointer....
	}
	
	private static Random random;


	public RandomlyGenerate (){
		random = new Random();
	}
	
	
}
