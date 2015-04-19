package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Entity.Skill;
import Model.Map.Grid.Tile.Tile;

public class Fireball extends SummonerAbility {
	
	private ArrayList<Tile> targetTiles;
	private Skill skill;

	public Fireball(ArrayList<Tile> targetTiles, Skill skill) {
        this.targetTiles = targetTiles;
        this.skill = skill;
    }

	@Override
    public void execute() {
		// sourceAvatar.checkMana(this);
	}

	@Override
	public void cast() {
		
	}

	@Override
	public int getSkillLevel() {
		return skill.getCurrentLevel();
	}

	@Override
	public int getRequiredMana() {
		return 5;
	}

	@Override
	protected int scaleMagnitude() {
		return 150 * getSkillLevel()/100;
	}

	protected ArrayList<Tile> getTargetTiles() {
		return null;
	}

	@Override
	protected Entity getSourceEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
