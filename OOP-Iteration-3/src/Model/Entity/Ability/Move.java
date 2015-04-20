package Model.Entity.Ability;

import Model.Entity.Entity;
import Model.Items.MapObject;
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
		GameMap map = sourceEntity.getGamemap();
		map.moveEntity(sourceEntity, direction);
	}

	@Override
	protected Entity getSourceEntity() {
		return sourceEntity;
	}

}
