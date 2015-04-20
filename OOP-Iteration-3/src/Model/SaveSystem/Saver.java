package Model.SaveSystem;

import Model.Entity.Entity;
import Model.Items.MapObject;
import Model.Map.HexagonalLocation;

public interface Saver {
	
	public String save(Entity entity);
	public String save(HexagonalLocation location , MapObject mapObject);
	//public String save(Entity entity);
	//public String save(AreaEffect areaEffect);
	
}
