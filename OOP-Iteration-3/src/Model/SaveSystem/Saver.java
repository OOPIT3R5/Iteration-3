package Model.SaveSystem;

import Model.Entity.Entity;
import Model.Items.AreaEffect;
import Model.Items.Item;

public interface Saver {
	
	public String save(Item item);
	public String save(Entity entity);
	public String save(AreaEffect areaEffect);
	
}
