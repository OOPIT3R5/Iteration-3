package Model.Entity.Ability;


public class HealManaItemAbility extends ItemAbility {
    private int MPHealed;

    public HealManaItemAbility(int MPHealed) {
        this.MPHealed = MPHealed;
    }

    @Override
    public void execute() {
        getSourceEntity().getStatistics().useMana(-1*MPHealed);
    }
}
