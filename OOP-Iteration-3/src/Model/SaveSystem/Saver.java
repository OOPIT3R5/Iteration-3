package Model.SaveSystem;

import Model.Entity.Entity;
import Model.Items.AreaEffect;
import Model.Items.Item;
import Model.Items.MapObject;

public interface Saver {
	
	public String save(Entity entity);
	public String save(MapObject mapObject);
	//public String save(Entity entity);
	//public String save(AreaEffect areaEffect);
	
}
