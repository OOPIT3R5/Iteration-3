package Model.Entity;

import Model.Items.*;

public class Smasher extends Occupation{
    private Skill onehandedweapon;
    private Skill twohandedweapon;
    private Skill brawlingweapon;

	public Smasher(Entity e) {
        super(e);
        onehandedweapon = new Skill(1, 25);
        twohandedweapon = new Skill(1, 25);
        brawlingweapon  = new Skill(1, 25);
	}



	@Override
    public void visit(SmasherWeaponItem smawi) {
       getEntity().equipItem(smawi);
    }

    @Override
    public void visit(SummonerWeaponItem sumwi) {
        getEntity().equipItem(sumwi);
    }

    @Override
    public void visit(SneakWeaponItem snewi) {
        getEntity().equipItem(snewi);
    }

    @Override
    public void visit(SummonerTomeOffHandItem stohi) {
        System.out.println("You can't equip this! A book does not make a good shield!");
    }

    @Override
    public void visit(SmasherShieldOffHandItem ssohi) {
        getEntity().equipItem(ssohi);
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

    public int getOneHandedWeaponSkillLevel(){
        return onehandedweapon.getCurrentLevel();
    }

    public int getTwoHandedWeaponSkillLevel(){
        return twohandedweapon.getCurrentLevel();
    }

    public int getBrawlingWeaponSkillLevel(){
        return brawlingweapon.getCurrentLevel();
    }

    public void levelOneHandedWeaponSkill(){
        onehandedweapon.levelSkillUp();
    }

    public void levelTwoHandedWeaponSkill(){
        twohandedweapon.levelSkillUp();
    }

    public void levelBrawlingWeaponSkill(){
        brawlingweapon.levelSkillUp();
    }
}