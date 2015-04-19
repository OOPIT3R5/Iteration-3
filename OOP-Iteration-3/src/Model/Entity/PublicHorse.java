package Model.Entity;

public class PublicHorse extends NonAdversarial implements Mount{

	Mounted m;
	public PublicHorse() {	// TODO PublicHorse class
		m = new Mounted(this);
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
