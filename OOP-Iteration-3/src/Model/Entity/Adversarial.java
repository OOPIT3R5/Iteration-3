package Model.Entity;

public abstract class Adversarial extends NPC {

	public Adversarial() {
		super();
		becomeHostile();
	}

	 public Adversarial(String name) {
		super(name);
		becomeHostile();
	}

	
	public Adversarial(String name, Occupation o) {
		super(name, o);
		becomeHostile();
	}

	@Override
	public void makeActionChoice(){
		super.makeActionChoice();
	}
	
	@Override
	public void receiveDamage(int damage) {
			stats.changeHealth(-damage);
			becomeHostile();
		}


	

}
