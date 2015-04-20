package Model.SaveSystem;

import Model.Entity.Entity;
import Model.Items.MapObject;
import Model.Map.HexagonalLocation;

public class CSVSaver implements Saver{



	@Override
	public String save(Entity entity) {
		StringBuilder builder = new StringBuilder();
		builder.append(entity.toString());
		return builder.toString();
	}

	@Override
	public String save(HexagonalLocation location , MapObject mapObject) {
		StringBuilder builder = new StringBuilder();
		builder.append(mapObject.getName() + " , " + location.toString());
		return builder.toString();
	}

	
	
	
}
