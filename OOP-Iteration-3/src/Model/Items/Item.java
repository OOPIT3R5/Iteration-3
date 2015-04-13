package Model.Items;


import Model.Entity.Statistic;
import Model.Entity.StatisticContainer;

public abstract class Item implements MapObject{

    StatisticContainer stats;

    //public Ability getAbility(){
//      return ability;
//}
    public StatisticContainer getStatistics(){
        return stats;
    }

    //public abstract void execute(Entity entity);

}
