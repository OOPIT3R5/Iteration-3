package Model.Entity.Ability;

import Model.Map.HexagonalLocation;
import Model.Map.Location;

public abstract class SkillAbility extends Ability {
    protected abstract int getSkillLevel();
    protected boolean checkDistance(HexagonalLocation a, HexagonalLocation b, int min, int max){
    	if(Math.abs(a.getV() - b.getV()) < min && Math.abs(a.getU() - b.getU()) < min){
    		return false;
    	}
    	else if(Math.abs(a.getV() - b.getV()) <= max && Math.abs(a.getU() - b.getU()) <= max){
    		return true;
    	}
    	return false;
    }
}
