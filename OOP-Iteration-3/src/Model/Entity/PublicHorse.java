package Model.Entity;

import Model.Entity.Ability.Ability;
import Model.Entity.Ability.DoNothing;

public class PublicHorse extends NonAdversarial implements Mount{

	Mounted m;
	public PublicHorse() {	// TODO PublicHorse class
		m = new Mounted(this);
		changeMovementSpeed(3);
	}

	
	public void makeActionChoice(){
		if (m.isMounted){
			makeMountedActionChoice();
		}
		else{
			makeUnMountedActionChoice();
		}
	}
	
	@Override
	public void makeMountedActionChoice() {
		m.forwardControlOfMountToRider();
		
	}

	@Override
	public void makeUnMountedActionChoice() {
		//TO DO
		//do nothing. Public horse is stabled at some location and doens't move
		Ability d = new DoNothing();
		
	}

	@Override
	public void mount(Avatar avatar) {
		m.mount(avatar);
		
	}

	@Override
	public void unMount() {
		m.unMount();
	}

}
