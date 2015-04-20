package Model.Entity.Ability;

import Model.Entity.Entity;
import Model.Items.MapObject;
import Model.Map.Direction;
import Model.Map.GameMap;
import Model.Map.Grid.Tile.Tile;

public class RiverMove extends Ability {
	
	private int movementSpeed;
    private Entity sourceEntity;
    private Direction direction;

	public RiverMove(Entity sourceEntity, Direction direction, int movementSpeed) {
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
			if (newTile.getMapObject() != null)
				newTile.getMapObject().onTouch(currentEntity);
			downstream();
			
		} else {	// turn around without moving forward
			currentEntity.setDirection(direction);
		}
	}

	private void downstream() {
		new Move(sourceEntity, Direction.SOUTH, movementSpeed).execute();
		new Move(sourceEntity, Direction.SOUTH, movementSpeed).execute();
	}

	@Override
	protected Entity getSourceEntity() {
		return sourceEntity;
	}

}
