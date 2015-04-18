package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Map.Grid.Tile.Tile;

public abstract class SkillAbility extends Ability {

    protected ArrayList<Tile> targetList;

    public SkillAbility(ArrayList<Tile> targetList) {
        this.setTargetList(targetList);
    }


    protected ArrayList<Tile> getTargetList() {
        return targetList;
    }

    protected void setTargetList(ArrayList<Tile> targetList) {
        this.targetList = targetList;
    }
}
