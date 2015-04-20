package Model.Entity.Ability;

import Model.Entity.Entity;

public class AwardGoldItemAbility extends ItemAbility{

    private int gold;

    public AwardGoldItemAbility(Entity entity, int gold) {
        super(entity);
        this.gold = gold;
    }

    @Override
    public void execute() {
        getSourceEntity().awardGold(gold);
    }
}
