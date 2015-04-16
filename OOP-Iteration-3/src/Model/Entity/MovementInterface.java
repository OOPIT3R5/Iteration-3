package Model.Entity;

public interface MovementInterface {
	
	public abstract void disableMove(int direction);
	
	public abstract void disableWalk(int direction);
	
	public abstract void enableMove(int direction);
	
}
