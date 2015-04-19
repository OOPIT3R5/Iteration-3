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
		//place avatar on map
	}
	public void mount(Avatar avatar){
		//take avatar off the map.
		setRider(avatar);
		isMounted = true;
	}
	
	public boolean isMounted(){
		return isMounted;
	}
	
	public void forwardControlOfMountToRider(){
		
	}
	
}
