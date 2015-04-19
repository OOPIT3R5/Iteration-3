package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Entity.NPC;
import Model.Entity.Skill;
import Model.Map.GameMap;
import Model.Map.Grid.Tile.Tile;
import Utility.RandomlyGenerate;

public class Charm extends SummonerAbility {

	private Entity sourceEntity;
	private GameMap map;
	private Skill skill;
	
	public Charm(Entity sourceEntity, GameMap map, Skill skill) {
		this.sourceEntity = sourceEntity;
		this.map = map;
		this.skill = skill;
    }
	
	@Override
	public void execute() {
		useMana(sourceEntity);
	}
	
	@Override
	public void cast() {
		Entity targetEntity = getTargetEntity();
		
		double probabilityOfSuccess = RandomlyGenerate.probability();
		double chanceOfSuccess = getSkillLevel()/100;
		
		if (chanceOfSuccess > probabilityOfSuccess){		// success
			getTargetEntity().charm();		
		} else {		// failure
			((NPC)targetEntity).provoke();
		}
		
	}

	@Override
	public int getRequiredMana() {
		return 20;
	}

	@Override
	protected int scaleMagnitude() {
		return 0;
	}

	@Override
	protected int getSkillLevel() {
		return skill.getCurrentLevel();
	}

	@Override
	protected Entity getSourceEntity() {
		return sourceEntity;
	}
	
	private Entity getTargetEntity() {
		return map.getEntity(getSourceEntity().getLocationFacing());
	}
}