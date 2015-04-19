package Model.Entity;

public class Statistic {

    private int minimum;
    private int maximum;
    private int currentvalue;
    private int temporaryvalue;
    private int levelupboost;

    public Statistic(){
        minimum = 0;
        maximum = Integer.MAX_VALUE;
        currentvalue = 0;
        levelupboost = 1;
    }

    public Statistic(int minimum, int maximum){
        this.minimum = minimum;
        this.maximum = maximum;
        currentvalue = minimum;//Set it up to be the lowest
        levelupboost = 1;
    }

    public Statistic(int minimum, int maximum, int levelupboost){
        this.minimum = minimum;
        this.maximum = maximum;
        currentvalue = minimum;
        this.levelupboost = levelupboost;
    }

    public int getCurrentValue(){
        if(currentvalue + temporaryvalue > maximum)
            return maximum;
        else return (currentvalue + temporaryvalue);
    }

    //PRECONDITION: This parameter is only passed once for the entirety of the temporary boost.
    public void addTemporaryValue(int tempval){
        temporaryvalue += tempval;
    }

    /* TODO REMOVE? Reason: Replicated behavior.Could just pass in negative value to addTemporaryValue()
    //PRECONDITION: The same parameter tempval must have been passed to the void addTemporaryValue() method earlier.
    public void removeTemporaryValue(int tempval){
        temporaryvalue -= tempval;
    } */

    public void addPermanentValue(int val){
        currentvalue += val;
        if (currentvalue > maximum)
            currentvalue = maximum;
        if (currentvalue < minimum)
            currentvalue = minimum;
    }

    public void levelUpStat(){
        addPermanentValue(levelupboost);
    }

    public void reset() {
        currentvalue = minimum;
    }


}
