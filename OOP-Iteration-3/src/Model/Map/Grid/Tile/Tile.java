package Model.Map.Grid.Tile;

import java.awt.Color;

import Model.Entity.Entity;
import Model.Entity.MovementInterface;
import Model.Items.MapObject;
import Model.Items.Trap;
import Model.Map.Direction;
import Model.Map.Location;
import Model.Terrain.Grass;
import Model.Terrain.Terrain;

public abstract class Tile {

	private final Terrain terrain_;
	private Location location_;
	private Entity entity_;
	private MapObject map_object_;
	private Trap trap_;
	
	public Tile() {
		terrain_ = new Grass();
	}
	
	public Tile(Terrain terrain) {
		terrain_ = terrain;
	}
	
	public void activateTrap(Entity e){
		if (trap_ != null)
			trap_.onTouch(e);
	}
	
	@Override
	public abstract Tile clone();
	
	public void detectTrap(){
		// TODO set trap visible 
	}
	
	public boolean equals(Tile other) {
		return location_.equals(other.getLocation())
				&& getTerrain() == other.getTerrain();
	}
	
	public Color getColor(){
		return terrain_.getColor();
	}

	public Entity getEntity() {
		return entity_;
	}
	
	public Location getLocation() {
		return location_;
	}

	public MapObject getMapObject() {
		return map_object_;
	}
	
	public Terrain getTerrain() {
		return terrain_;
	}
	
	public Trap getTrap(){
		return trap_;
	}

	public boolean hasEntity() {
		return (entity_ != null);
	}
	
	public boolean hasMapObject() {
		// TODO Auto-generated method stub
		if(this.map_object_ != null)
			return true;
		else return false;
	}
	
	public abstract void notifyOfEntity(MovementInterface target, Direction direction);
	
	public void nullify()
	{
		this.entity_ = null;
		this.map_object_ = null;
	}
	
	public abstract void prospectiveMovement(MovementInterface target, Direction direction);
	
	public void putLocation(Location location) {
		location_ = location;
	}
	
	public void removeEntity() {
		entity_ = null;
	}
	
	public void removeTrap(){
		trap_ = null;
	}
	
	public void setEntity(Entity entity) {
		entity_ = entity;
		System.out.println(entity_.toString()+" ENTITY IT SHOULD BE SETTING TO"+ entity.toString());
	}
	
	public abstract void setLocation(int x, int y);

	public abstract void setLocation(Location location);
	public void setMapObject(MapObject map_object) {
		map_object_ = map_object;
	}

	public void setTrap(Trap t){
		trap_ = t;
	}
	
	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("Tile");
		builder.append(terrain_.toString());
		//builder.append();
		
		return builder.toString();
	}
	
}
