package Model.Entity;

public interface Mount {
	public abstract void makeMountedActionChoice();
	public abstract void makeUnMountedActionChoice();
	public abstract void mount(Avatar avatar);
	public abstract void unMount();
}
