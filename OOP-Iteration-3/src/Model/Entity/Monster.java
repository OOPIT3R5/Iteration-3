package Model.Entity;

public class Monster extends Adversarial{

	public Monster() {
		super("evilMonster");
		setOccupation(new Smasher(this));
		hostility.becomeHostile();
	}
	
	public Monster(String name, Occupation o) {
		super(name, o);
		hostility.becomeHostile();
	}
}
