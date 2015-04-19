package Model.Entity;

import java.util.HashMap;
import java.util.Map;

import Model.Items.*;

public class Summoner extends Occupation{

    private Skill enchantment;
    private Skill boon;
    private Skill bane;
    private Skill staff;

	public Summoner(Entity e){
        super(e);
        enchantment = new Skill(1, 10);
        boon        = new Skill(1, 20);
        bane        = new Skill(1, 20);
        staff       = new Skill(1,  5);
    }



	@Override
    public void visit(SmasherWeaponItem smawi) {
        System.out.println("You are not able to equip the "+smawi.getName()+" due to being too weak!");
    }

    @Override
    public void visit(SummonerWeaponItem sumwi) {
        getEntity().equipItem(sumwi);
    }

    @Override
    public void visit(SneakWeaponItem snewi) {
        System.out.println("You are not able to equip the "+snewi.getName()+". Besides, it's not your style to sneak up on people.");
    }

    @Override
    public void visit(SummonerTomeOffHandItem stohi) {
        getEntity().equipItem(stohi);
    }

    @Override
    public void visit(SmasherShieldOffHandItem ssohi) {
        System.out.println("You cannot equip the "+ssohi.getName()+"! You can't carry a shield and cast a spell at someone at the same time.");
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

    public int getEnchantmentSkillLevel(){
        return enchantment.getCurrentLevel();
    }

    public int getBaneSkillLevel(){
        return bane.getCurrentLevel();
    }

    public int getBoonSkillLevel(){
        return boon.getCurrentLevel();
    }

    public int getStaffSkillLevel(){
        return staff.getCurrentLevel();
    }

    public void levelEnchantmentSkill(){
        enchantment.levelSkillUp();
    }

    public void levelBaneSkill(){
        bane.levelSkillUp();
    }

    public void levelBoonSkill(){
        boon.levelSkillUp();
    }
    public void levelStaffSkill(){
        staff.levelSkillUp();
    }
    
    protected Map<? extends String, ? extends Skill> getSkillsSub() {
		HashMap<String, Skill> skills = new HashMap<String, Skill>();

		skills.put("Enchantment",enchantment);
		skills.put("Boon", boon);
		skills.put("Bane", bane);
		skills.put("Staff", staff);
		return skills;
	}
    
    
    
    
}
