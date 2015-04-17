package Model.Entity;

public class StatisticContainer {
    private Statistic strength;
    private Statistic agility;
    private Statistic intellect;
    private Statistic hardiness;
    private Statistic experience;
    private Statistic movement;
    private Statistic level;

    public StatisticContainer(){
        strength = new Statistic();
        agility = new Statistic();
        intellect = new Statistic();
        hardiness = new Statistic();
        experience = new Statistic();
        movement = new Statistic(1,50);
        level = new Statistic(1,100,0);
    }

    public int getLevel(){
        return level.getCurrentValue();
    }

    public int getStrength() {
        return strength.getCurrentValue();
    }

    public int getAgility(){
        return agility.getCurrentValue();
    }

    public int getIntellect(){
        return intellect.getCurrentValue();
    }

    public int getHardiness(){
        return hardiness.getCurrentValue();
    }

    public int getMovement(){
        return movement.getCurrentValue();
    }

    private void checkLevelUp(){
        if(level.getCurrentValue() < (experience.getCurrentValue() / 1000)){
            level.addPermanentValue(1);             //Update level.
            levelupAllStatistics();                 //Level up all primary statistics.
        }
    }

    public void awardExperience(int experience){
        this.experience.addPermanentValue(experience);  // Add the experience to the container.
        checkLevelUp();                                 // Check if we had a level up after this.
    }

    private void levelupAllStatistics(){
        strength.levelUpStat();
        agility.levelUpStat();
        intellect.levelUpStat();
        hardiness.levelUpStat();
        movement.levelUpStat();
    }
}
