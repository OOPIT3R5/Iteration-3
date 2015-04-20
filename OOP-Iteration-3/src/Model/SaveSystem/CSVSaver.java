package Model.SaveSystem;

import java.io.IOException;

import Model.Entity.Entity;
import Model.Entity.Ability.DoNothing;
import Model.Items.AreaEffect;
import Model.Items.Item;
import Model.Items.MapObject;
import Model.Items.ShoesItem;
import Model.Map.HexagonalLocation;
import View.Model.MapObjectView;

public class CSVSaver implements Saver{



	@Override
	public String save(HexagonalLocation location , MapObject mapObject) {
		StringBuilder builder = new StringBuilder();
		builder.append(mapObject.getName() + " , " + location.toString());
		return builder.toString();
	}

	@Override
	public String save(Entity entity) {
		StringBuilder builder = new StringBuilder();
		builder.append(entity.toString());
		return builder.toString();
	}

	
	
	
}
