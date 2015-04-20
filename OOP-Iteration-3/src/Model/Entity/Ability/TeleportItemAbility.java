package Model.Entity.Ability;

import Model.Entity.Entity;

public class TeleportItemAbility extends ItemAbility{

    private int teleportSpotX;
    private int teleportSpotY;

    public TeleportItemAbility(int X, int Y) {
        teleportSpotX = X;
        teleportSpotY = Y;
    }

    @Override
    public void execute() {
        getSourceEntity().teleport(teleportSpotX, teleportSpotY);
    }
}
