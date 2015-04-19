package Model.Entity;

public class Mounted {

	protected Avatar rider;
	protected Mount mount;
	protected boolean isMounted;
	public Mounted(){
		
		isMounted = false;
	}
	
	public Mounted(Mount mount){
		this.mount = mount;
		isMounted = false;
	}
	
	
	public Mounted(Avatar rider, Mount mount){
		this.rider = rider;
		this.mount = mount;
		isMounted = true;
	}
	
	
	public void setMount(Mount m){
	 this.mount = m;	
	}
	
	public void setRider(Avatar a){
		this.rider  = a;
	}
	
	public void unMount(){
		isMounted = false;
		//rider.setDecal(((NPC)mount).getDecal())
		//change avatar decal to avatar's decal
		//move avatar to adjacent tile
		//place mount on map where avatar was last
	}
	public void mount(Avatar avatar){
		// remove mount from map.
		//change avatar decal to mount's
		//place avatar on mount's tile/last position

		setRider(avatar);
		isMounted = true;
	}
	
	public boolean isMounted(){
		return isMounted;
	}
	
	public void forwardControlOfMountToRider(){
		
	}
	
}
