package Utility;

import java.util.Random;

import Model.Entity.Ability.Ability;
import Model.Entity.Ability.Move;
import Model.Map.Direction;

public class RandomGenerator {
	Random random;
	
	public RandomGenerator (){
		random = new Random();
	}
	
	public double probabiltiy(){
		return random.nextDouble();
	}


	public Direction direction() {
		double r = probabiltiy();
		
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
	
	
}
