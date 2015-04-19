package Model.Entity;

public class NonAdversarial extends NPC{


	public NonAdversarial() {	// TODO NonAdversarial class
		super();
		becomeNonHostile();
	}

	public NonAdversarial(String name, Occupation o) {
		super(name, o);
		becomeNonHostile();
	}

	public NonAdversarial(String name) {
		super(name);
		becomeNonHostile();
	}

}
