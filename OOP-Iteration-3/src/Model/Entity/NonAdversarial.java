package Model.Entity;

public class NonAdversarial extends NPC{


	public NonAdversarial() {	// TODO NonAdversarial class
		super();
		becomeNonHostile();
	}

	public NonAdversarial(String name) {
		super(name);
		becomeNonHostile();
	}

	public NonAdversarial(String name, Occupation o) {
		super(name, o);
		becomeNonHostile();
	}

	@Override
	public void makeActionChoice(){
		super.makeActionChoice();
	}
	
}
