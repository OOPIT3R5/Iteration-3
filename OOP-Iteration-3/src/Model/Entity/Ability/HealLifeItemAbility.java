package Model.Entity.Ability;

public class HealLifeItemAbility extends ItemAbility {

    private int HPHealed;

    public HealLifeItemAbility(int HPHealed) {
        this.HPHealed = HPHealed;
    }

    @Override
    public void execute() {
        getSourceEntity().changeHealth(HPHealed);
    }
}
