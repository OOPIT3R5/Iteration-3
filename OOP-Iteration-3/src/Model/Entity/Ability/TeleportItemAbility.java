package Model.Entity.Ability;

import Model.Entity.Entity;
import Model.Map.GameMap;
import Model.Map.Grid.Tile.Tile;
import Model.Map.HexagonalLocation;

public class TeleportItemAbility extends ItemAbility{

    private int teleportSpotX;
    private int teleportSpotY;
    private GameMap map;

    public TeleportItemAbility(int X, int Y, GameMap map ) {
        teleportSpotX = X;
        teleportSpotY = Y;
        this.map = map;
    }

    @Override
    public void execute() {
        Tile oldTile = map.getTile(getSourceEntity().getLocation());
        Tile newTile = map.getTile(new HexagonalLocation(teleportSpotX, teleportSpotY));
        oldTile.removeEntity();
        newTile.setEntity(getSourceEntity());
    }
}
