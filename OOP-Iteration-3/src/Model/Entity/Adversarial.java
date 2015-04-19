package Model.Entity;

public abstract class Adversarial extends NPC {

	public Adversarial() {
		super();
		becomeHostile();
	}

	public Adversarial(String name, Occupation o) {
		super(name, o);
		becomeHostile();
	}

	public Adversarial(String name) {
		super(name);
		becomeHostile();
	}
	
	public void makeActionChoice(){
		super.makeActionChoice();
	}


	

}
