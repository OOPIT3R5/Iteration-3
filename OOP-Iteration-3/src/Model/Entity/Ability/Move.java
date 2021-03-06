package Model.Entity.Ability;

import Model.Entity.Entity;
import Model.Map.Direction;
import Model.Map.GameMap;
import Model.Map.Grid.Tile.Tile;

public class Move extends Ability {
	
	private int movementSpeed;
    private Entity sourceEntity;
    private Direction direction;

	public Move(Entity sourceEntity, Direction direction, int movementSpeed) {
	    this.sourceEntity = sourceEntity;
		this.direction = direction;
		this.movementSpeed = movementSpeed;
    }

	@Override
	public void execute() {
		Entity currentEntity = getSourceEntity();
		GameMap map = sourceEntity.getGamemap();
		
		Tile oldTile = map.getTile(currentEntity.getLocation());
		if (currentEntity.getDirectionFacing() == direction) {		// move forward
			currentEntity.setLocation(currentEntity.getLocation().getNeighbor(direction));		// incorporate movement speed?
			Tile newTile = map.getTile(currentEntity.getLocation());
			oldTile.removeEntity();
			newTile.setEntity(currentEntity);
			if (newTile.getMapObject() != null){
				newTile.getMapObject().onTouch(currentEntity);
				newTile.setMapObject(null);
			}
		} else {	// turn around without moving forward
			currentEntity.setDirection(direction);
		}
	}

	@Override
	protected Entity getSourceEntity() {
		return sourceEntity;
	}

}
