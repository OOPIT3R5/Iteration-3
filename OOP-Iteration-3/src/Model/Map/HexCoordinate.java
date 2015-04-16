package Model.Map;

import java.util.ArrayList;

/**
 * 
 * Hex coordinate class. Stores coordinates as u and v.
 * Supports retrieval of cubic coordinates.
 * 
 * @author Jack
 *
 */
public class HexCoordinate extends Vector2D {
	
	// TODO - Other mathematical operations as static methods.
	
	public static ArrayList<HexCoordinate> arc(HexCoordinate center, int size, Direction d) {
		ArrayList<HexCoordinate> arc = new ArrayList<HexCoordinate>();
		for (int radius = 1; radius < size + 1; radius++)
			arc.addAll(arcRing(center, radius, d));
		return arc;
	}
	
	public static ArrayList<HexCoordinate> arcRing(HexCoordinate center, int radius, Direction d) {
		ArrayList<HexCoordinate> arc_ring = new ArrayList<HexCoordinate>();
		int direction = Direction.hexToInt(d);
		HexCoordinate start = center;
		for (int length = 0; length < radius; length++)
			start = start.getNeighbor(direction);
		arc_ring.add(start);
		HexCoordinate counter_clockwise = start;
		HexCoordinate clockwise = start;
		for (int arc_length = 0; arc_length < radius / 2; arc_length++) {
			counter_clockwise = counter_clockwise.getNeighbor(direction + 2);
			arc_ring.add(counter_clockwise);
			clockwise = clockwise.getNeighbor(direction - 2);
			arc_ring.add(clockwise);
		}
		return arc_ring;
	}
	
	public static ArrayList<HexCoordinate> circle(HexCoordinate center, int radius) {
		ArrayList<HexCoordinate> circle = new ArrayList<HexCoordinate>();
		circle.add(center);
		for (int i = 0; i < radius; i++)
			circle.addAll(HexCoordinate.ring(center, i + 1));
		return circle;
	}
	
	public static ArrayList<HexCoordinate> line(HexCoordinate start, int length) {
		ArrayList<HexCoordinate> line = new ArrayList<HexCoordinate>();
		HexCoordinate next = start;
		for (int i = 0; i < length; i++) {
			next = next.getNeighbor(Direction.SOUTH);
			line.add(next.clone());
		}
		return line;
	}
	
	public static ArrayList<HexCoordinate> rectangle(HexCoordinate center, int width_radius, int height_radius) {
		ArrayList<HexCoordinate> rectangle = new ArrayList<HexCoordinate>();
		HexCoordinate top = center.clone();
		boolean odd = false;
		for (int move_left = 0; move_left < width_radius; move_left++) {
			if (!odd)
				top = top.getNeighbor(Direction.SOUTHWEST);
			else
				top = top.getNeighbor(Direction.NORTHWEST);
			odd = !odd;
		}
		for (int move_up = 0; move_up < height_radius; move_up++)
			top = top.getNeighbor(Direction.NORTH);
		for (int col = 0; col < 2 * width_radius + 1; col++) {
			rectangle.add(top.clone());
			if (!odd) {
				rectangle.addAll(HexCoordinate.line(top, height_radius * 2));
				top = top.getNeighbor(Direction.SOUTHEAST);
			} else {
				rectangle.addAll(HexCoordinate.line(top, height_radius * 2 - 1));
				top = top.getNeighbor(Direction.NORTHEAST);
			}
			odd = !odd;
		}
		return rectangle;
	}
	
	public static ArrayList<HexCoordinate> ring(HexCoordinate center, int radius) {
		ArrayList<HexCoordinate> ring = new ArrayList<HexCoordinate>();
		HexCoordinate hex = new HexCoordinate(center.getU(), center.getV() + radius);
		for (int direction = 0; direction < 6; direction++)
			for (int i = 0; i < radius; i++) {
				ring.add(hex.clone());
				hex = hex.getNeighbor(direction);
			}
		return ring;
	}
	
	/** Rectilinear distance between two Hex coordinates. */
	public static int rectilinearDistance(HexCoordinate a, HexCoordinate b) {
		return Math.max(Math.max(Math.abs(a.getX() - b.getX()), Math.abs(a.getY() - b.getY())), Math.abs(a.getZ() - b.getZ()));
	}
	
	/** Stores uv axial coordinates. */
	public HexCoordinate(int u, int v) {
		super(u, v);
	}

	public HexCoordinate clone() {
		return new HexCoordinate(getU(), getV());
	}
	
	/** Gets axial coordinates for potentially neighboring hex tiles. */
	@Override
	public HexCoordinate getNeighbor(Direction d) {
		return getNeighbor(Direction.hexToInt(d));
	}
	
	/** Gets axial coordinates for potentially neighboring hex tiles. */
	@Override
	public HexCoordinate getNeighbor(int d) {
		d = d % 6;
		if (d < 0)
			d += 6;
		switch (d) {
			case 0:
				return new HexCoordinate(getU()+1, getV()-1);
			case 1:
				return new HexCoordinate(getU(), getV()-1);
			case 2:
				return new HexCoordinate(getU()-1, getV());
			case 3:
				return new HexCoordinate(getU()-1, getV()+1);
			case 4:
				return new HexCoordinate(getU(), getV()+1);
			case 5:
				return new HexCoordinate(getU()+1, getV());
		}
		return null;
	}
	
	/** Returns axial coordinate u. */
	public int getU() {
		return super.getX();
	}
	
	/** Returns axial coordinate v. */
	public int getV() {
		return super.getY();
	}
	
	/** Returns cube coordinate x. */
	public int getX() {
		return getU();
	}
	
	/** Returns cube coordinate y. */
	@Override
	public int getY() {
		return - getU() - getV();
	}
	
	/** Returns cube coordinate z. */
	public int getZ() {
		return getV();
	}
	
	public String toString() {
		return getU() + " , " + getV();
	}
	
}
