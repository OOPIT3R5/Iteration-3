package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Map.Direction;
import Model.Map.GameMap;

public class Move extends Ability {
	
	private int movementSpeed;
	private GameMap map;
    private Entity sourceEntity;

	public Move(Entity sourceEntity, GameMap map, int movementSpeed) {
	    this.sourceEntity = sourceEntity;
		this.map = map;
		this.movementSpeed = movementSpeed;
    }

	@Override
	public void execute() {
		Entity currentEntity = getSourceEntity();
		//map.getTile(currentEntity.getLocation());		// get oldTile
		//currentEntity.setLocation(currentEntity.getLocation().getNeighbor(direction));		// incorporate movement speed?
		// get newTile
		// remove Entity from oldTile
		// place Entity on newTile
	}

	@Override
	protected Entity getSourceEntity() {
		return sourceEntity;
	}

}
