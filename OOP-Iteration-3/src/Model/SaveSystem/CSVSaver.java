package Model.SaveSystem;

import java.io.IOException;

import Model.Entity.Entity;
import Model.Entity.Ability.DoNothing;
import Model.Items.AreaEffect;
import Model.Items.Item;
import Model.Items.ShoesItem;
import View.MapObjectView;

public class CSVSaver implements Saver{

	@Override
	public String save(Item item) {
		StringBuilder builder = new StringBuilder();
		
		String itemType = item.toString();
		
		builder.append("<Item>");
		return builder.toString();
	}

	@Override
	public String save(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save(AreaEffect areaEffect) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
