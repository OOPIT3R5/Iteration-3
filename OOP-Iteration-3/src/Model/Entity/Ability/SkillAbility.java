package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Map.Grid.Tile.Tile;

public abstract class SkillAbility extends Ability {

    private ArrayList<Tile> targetList;
    private Entity entity;

    public SkillAbility(ArrayList<Tile> targetList, Entity source) {
        this.setTargetList(targetList);
        entity = source;
    }

    public Entity getEntity() {
        return entity;
    }

    protected ArrayList<Tile> getTargetList() {
        return targetList;
    }

    protected void setTargetList(ArrayList<Tile> targetList) {
        this.targetList = targetList;
    }
}
