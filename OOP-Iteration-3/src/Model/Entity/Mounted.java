package Model.Entity;

public class Mounted {

	protected Avatar rider;
	protected Mount mount;
	protected boolean isMounted;
	
	private int avatarDefaultSpeed;
	private int mountDefaultSpeed;
	private int changeInSpeed;
	
	public Mounted(){
		
		isMounted = false;
	}
	
	public Mounted(Avatar rider, Mount mount){
		this.rider = rider;
		this.mount = mount;
		isMounted = true;
		avatarDefaultSpeed = rider.getMovementSpeed();
		mountDefaultSpeed = ((Entity) mount).getMovementSpeed();
		changeInSpeed = mountDefaultSpeed-avatarDefaultSpeed;
	
	}
	
	
	public Mounted(Mount mount){
		this.mount = mount;
		isMounted = false;
		avatarDefaultSpeed = 0;
		mountDefaultSpeed = ((Entity) mount).getMovementSpeed();
		changeInSpeed = mountDefaultSpeed-avatarDefaultSpeed;
	}
	
	
	public void forwardControlOfMountToRider(){
		((Entity)mount).setLocation(rider.getLocation());
	}
	
	public boolean isMounted(){
		return isMounted;
	}
	
	public void mount(Avatar avatar){
		
		if(isMounted == false){
			setRider(avatar);
			isMounted = true;
			((Entity)mount).setLocation(avatar.getLocation());
		
			avatar.changeMovementSpeed(changeInSpeed);
		}
	}
	public void setMount(Mount m){
	 this.mount = m;	
	 mountDefaultSpeed = ((Entity) mount).getMovementSpeed();
	 changeInSpeed = mountDefaultSpeed-avatarDefaultSpeed;
	}
	
	public void setRider(Avatar a){
		this.rider  = a;
		if(rider!=null)
			avatarDefaultSpeed = rider.getMovementSpeed();
		else
			avatarDefaultSpeed = 0;
		changeInSpeed = mountDefaultSpeed-avatarDefaultSpeed;
	}
	
	public void unMount(){
		
		if(isMounted ==true){
			isMounted = false;
			rider.changeMovementSpeed(-changeInSpeed);
			setRider(null);
		
		}
		//change avatar decal to avatar's decal
		//move avatar to adjacent tile
		//place mount on map where avatar was last
	}
	
}
