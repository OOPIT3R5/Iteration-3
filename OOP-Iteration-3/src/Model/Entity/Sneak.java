package Model.Entity;

import Model.Items.*;

public class Sneak extends Occupation{

    private Skill pickpocket;
    private Skill detecttraps;
    private Skill creep;
    private Skill rangedweapon;

	public Sneak(Entity e){
        super(e);
        pickpocket  = new Skill(1,10);
        detecttraps = new Skill(1,10);
        creep       = new Skill(1,10);
        rangedweapon= new Skill(1,25);
    }

    //TODO: Replace all 'System.out.println()' methods with something with Logger.

   
	@Override
    public void visit(SmasherWeaponItem smawi) {
        System.out.println("You are not able to equip the "+smawi.getName()+" due to being too weak!");
    }

    @Override
    public void visit(SummonerWeaponItem sumwi) {
        System.out.println("You are not able to equip the "+sumwi.getName()+" as it has a strange aura surrounding it.");
    }

    @Override
    public void visit(SneakWeaponItem snewi) {
        getEntity().equipItem(snewi);
    }

    @Override
    public void visit(SummonerTomeOffHandItem stohi) {
        System.out.println("You cannot equip the "+stohi.getName()+"! You don't want to damage your loot.");
    }

    @Override
    public void visit(SmasherShieldOffHandItem ssohi) {
        System.out.println("You cannot equip the "+ssohi.getName()+"! You can't carry a shield and assassinate someone at the same time.");
    }

    @Override
    public void visit(ArmorItem ai) {
        getEntity().equipItem(ai);
    }

    @Override
    public void visit(AccessoryItem acci) {
        getEntity().equipItem(acci);
    }

    @Override
    public void visit(ShoesItem si) {
        getEntity().equipItem(si);
    }

    public int getPickpocketSkillLevel(){
        return pickpocket.getCurrentLevel();
    }

    public int getDetectTrapsSkillLevel(){
        return detecttraps.getCurrentLevel();
    }

    public int getCreepSkillLevel(){
        return creep.getCurrentLevel();
    }

    public int getRangedWeaponSkillLevel(){
        return rangedweapon.getCurrentLevel();
    }

    public void levelPickpocketSkill(){
        pickpocket.levelSkillUp();
    }

    public void levelDetectTrapsSkill(){
        detecttraps.levelSkillUp();
    }

    public void levelCreepSkill(){
        creep.levelSkillUp();
    }
    public void levelRangedWeaponSkill(){
        rangedweapon.levelSkillUp();
    }
}
