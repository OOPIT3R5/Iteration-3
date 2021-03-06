package Model.Entity;

public class StatisticContainer {
    private Entity e;

    private Statistic strength;
    private Statistic agility;
    private Statistic intellect;
    private Statistic hardiness;
    private Statistic experience;
    private Statistic movement;
    private Statistic level;

    private Statistic livesleft;    //USED FOR DEATH
    private Statistic life;         //USED FOR HEALTH
    private Statistic mana;         //USED FOR SPELLS

    private Statistic offense;      //USED FOR WEAPONS
    private Statistic defense;      //USED FOR OTHER EQUIPMENT


    public StatisticContainer(Entity e){
        strength = new Statistic();
        agility = new Statistic();
        intellect = new Statistic();
        hardiness = new Statistic();
        experience = new Statistic();

        strength.addPermanentValue(5);
        agility.addPermanentValue(5);
        intellect.addPermanentValue(5);
        hardiness.addPermanentValue(5);

        movement = new Statistic(1,50);
        level = new Statistic(1,100,0);

        livesleft = new Statistic(0, 9, 0);
        livesleft.addPermanentValue(3);         //Start with 3 life
        life = new Statistic(0, 100, 50);
        mana = new Statistic(0, 100, 25);

        life.addPermanentValue(100);
        mana.addPermanentValue(100);

        offense = new Statistic();
        defense = new Statistic();

        this.e = e;
    }

    public StatisticContainer(Entity e, int NumLives){
        strength = new Statistic();
        agility = new Statistic();
        intellect = new Statistic();
        hardiness = new Statistic();
        experience = new Statistic();

        strength.addPermanentValue(5);
        agility.addPermanentValue(5);
        intellect.addPermanentValue(5);
        hardiness.addPermanentValue(5);

        movement = new Statistic(1,50);
        level = new Statistic(1,100,0);

        livesleft = new Statistic(0, 9, 0);
        livesleft.addPermanentValue(NumLives);         //Start with X lives
        life = new Statistic(0, 100, 50);
        mana = new Statistic(0, 100, 25);

        life.addPermanentValue(100);
        mana.addPermanentValue(100);

        offense = new Statistic();
        defense = new Statistic();

        this.e = e;
    }


    public void addDefense(int amt){
        defense.addTemporaryValue(amt);
    }

    public void addOffense(int amt){
        offense.addTemporaryValue(amt);
    }

    public void awardExperience(int experience){
        this.experience.addPermanentValue(experience);  // Add the experience to the container.
        checkLevelUp();                                 // Check if we had a level up after this.
    }

    public void changeHealth(int change){
        life.addPermanentValue(change);
        checkIfDead();
    }

    private void checkIfDead() {
        if(life.getCurrentValue() <= 0){
    		life.addPermanentValue(9000);;
            livesleft.addPermanentValue(-1);
        }

        	if(livesleft.getCurrentValue() == 0){
              
        		e.removeFromMap();
        	}
        }

    private void checkIfGameOver() {
        if(livesleft.getCurrentValue() <= 0) {
           // e.setLocation(null);
        }
        else
            life.addPermanentValue(life.getMaxValue());   //Make it go back to the top.
    }

    private void checkLevelUp(){
        if(experience.getCurrentValue() > 1000){
            level.addPermanentValue(1);             //Update level.
            levelupAllStatistics();                 //Level up all primary statistics.
            experience.reset();
        }
    }

    public int getAgility(){
        return agility.getCurrentValue();
    }

    public int getArmorRating(){
        return defense.getCurrentValue() + level.getCurrentValue();
    }
    public int getDefensiveRating(){
        return agility.getCurrentValue() + level.getCurrentValue();
    }
    public int getExperience() {
        return experience.getCurrentValue();
    }
    public int getHardiness(){
        return hardiness.getCurrentValue();
    }

    public int getIntellect(){
        return intellect.getCurrentValue();
    }
    public int getLevel(){
        return level.getCurrentValue();
    }

    public int getLife(){
        return life.getCurrentValue();
    }

    public int getMana(){
        return mana.getCurrentValue();
    }
    
    public int getMaxLife(){
        return life.getMaxValue();
    }

    public int getMaxLivesLeft(){
        return livesleft.getMaxValue();
    }

    public int getMaxMana(){
        return mana.getMaxValue();
    }

    public int getMovement(){
        return movement.getCurrentValue();
    }

    public int getNumLivesLeft(){
        return livesleft.getCurrentValue();
    }

    public int getOffensiveRating(){
        return offense.getCurrentValue() + level.getCurrentValue();
    }

    public int getStrength() {
        return strength.getCurrentValue();
    }

    public void increaseSpeed(int newSpeed) {
		movement = new Statistic(newSpeed, 50);
	}

    private void levelupAllStatistics(){
        strength.levelUpStat();
        agility.levelUpStat();
        intellect.levelUpStat();
        hardiness.levelUpStat();
        movement.levelUpStat();
    }
    

    public void regenMana(){
    	mana.addPermanentValue(5);
    }

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append(strength.getCurrentValue() + ",");
		builder.append(agility.getCurrentValue() + ",");
		builder.append(intellect.getCurrentValue() + ",");
		builder.append(hardiness.getCurrentValue()+ ",");
	    builder.append(experience.getCurrentValue()+ ",");
	    builder.append(movement.getCurrentValue()+ ",");
	    builder.append(level.getCurrentValue()+ ",");
	    builder.append(livesleft.getCurrentValue()+ ",");
	    builder.append(life.getCurrentValue()+ ",");
	    builder.append(mana.getCurrentValue()+ ",");
	    builder.append(offense.getCurrentValue()+ ",");
	    builder.append(defense.getCurrentValue()+ ",");
		return builder.toString();
	}
	
	public boolean useMana(int manausage){
    	if (manausage > getMana()){
    		return false;
    	} else {
    		mana.addPermanentValue(-1*manausage);
    		return true;
    	}
    }
}
