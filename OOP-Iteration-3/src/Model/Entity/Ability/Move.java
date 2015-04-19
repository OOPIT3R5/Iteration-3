package Model.Entity.Ability;

import Model.Entity.Entity;
import Model.Map.Direction;
import Model.Map.GameMap;
import Model.Map.Grid.Tile.Tile;

public class Move extends Ability {
	
	private int movementSpeed;
	private GameMap map;
    private Entity sourceEntity;
    private Direction direction;

	public Move(Entity sourceEntity, GameMap map, Direction direction, int movementSpeed) {
	    this.sourceEntity = sourceEntity;
		this.map = map;
		this.direction = direction;
		this.movementSpeed = movementSpeed;
    }

	@Override
	public void execute() {
		Entity currentEntity = getSourceEntity();
		Tile oldTile = map.getTile(currentEntity.getLocation());
		currentEntity.setDirection(direction);
		currentEntity.setLocation(currentEntity.getLocation().getNeighbor(direction));		// incorporate movement speed?
		Tile newTile = map.getTile(currentEntity.getLocation());
		oldTile.removeEntity();
		newTile.setEntity(currentEntity);
	}

	@Override
	protected Entity getSourceEntity() {
		return sourceEntity;
	}

}
