package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Entity.Skill;
import Model.Map.Grid.Tile.Tile;
import Utility.RandomlyGenerate;

public class DetectTrap{
	
	private ArrayList<Tile> targetTiles;
	private Skill skill;

	public DetectTrap(ArrayList<Tile> targetTiles, Skill skill) {
        this.targetTiles = targetTiles;
        this.skill = skill;
    }

	public void execute() {
		double chanceOfSuccess = getSkillLevel()/100;
		
		for(Tile tile : targetTiles){
			double probabilityOfSuccess = RandomlyGenerate.probability();
			if (chanceOfSuccess > probabilityOfSuccess){		// success = detection
				detectTargetTrap(tile);
			}
		}
	}

	public void detectTargetTrap(Tile tile){
		tile.detectTrap();
	}
	
	public int getSkillLevel() {
		return skill.getCurrentLevel();
	}

}
