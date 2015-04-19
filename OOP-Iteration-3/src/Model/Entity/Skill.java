package Model.Entity;

public class Skill {
    private int minimumlevel;
    private int maximumlevel;
    private int currentlevel;
    private String name;

    public Skill(int min, int max, String name){
        minimumlevel = currentlevel = min;
        maximumlevel = max;
        this.name = name;
    }

    //Level up skill ONCE. If it's higher than maximum level, do not let it go past that.
    public void levelSkillUp(){
        if(++currentlevel > maximumlevel)
            currentlevel = maximumlevel;
    }

    public int getCurrentLevel(){
        return currentlevel;
    }

    public String getName(){
        return name;
    }
}
