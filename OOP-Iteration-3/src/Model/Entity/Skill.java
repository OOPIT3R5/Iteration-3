package Model.Entity;

public class Skill {
    private int minimumlevel;
    private int maximumlevel;
    private int currentlevel;

    public Skill(int min, int max){
        minimumlevel = currentlevel = min;
        maximumlevel = max;
    }

    //Level up skill ONCE. If it's higher than maximum level, do not let it go past that.
    public void levelSkillUp(){
        if(++currentlevel > maximumlevel)
            currentlevel = maximumlevel;
    }

    public int getCurrentLevel(){
        return currentlevel;
    }
}
