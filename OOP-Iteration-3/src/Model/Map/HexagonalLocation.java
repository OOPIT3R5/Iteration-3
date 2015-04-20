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
public class HexagonalLocation extends Location implements HexagonalCoordinateInterface {
	
	// TODO - Other mathematical operations as static methods.
	
	public static ArrayList<HexagonalLocation> arc(HexagonalLocation center, int size, Direction d) {
		ArrayList<HexagonalLocation> arc = new ArrayList<HexagonalLocation>();
		for (int radius = 1; radius < size + 1; radius++)
			arc.addAll(arcRing(center, radius, d));
		return arc;
	}
	
	public static ArrayList<HexagonalLocation> arcRing(HexagonalLocation center, int radius, Direction d) {
		ArrayList<HexagonalLocation> arc_ring = new ArrayList<HexagonalLocation>();
		int direction = Direction.hexToInt(d);
		HexagonalLocation start = center;
		for (int length = 0; length < radius; length++)
			start = start.getNeighbor(direction);
		arc_ring.add(start);
		HexagonalLocation counter_clockwise = start;
		HexagonalLocation clockwise = start;
		for (int arc_length = 0; arc_length < radius / 2; arc_length++) {
			counter_clockwise = counter_clockwise.getNeighbor(direction + 2);
			arc_ring.add(counter_clockwise);
			clockwise = clockwise.getNeighbor(direction - 2);
			arc_ring.add(clockwise);
		}
		return arc_ring;
	}
	
	public static ArrayList<HexagonalLocation> circle(HexagonalLocation center, int radius) {
		ArrayList<HexagonalLocation> circle = new ArrayList<HexagonalLocation>();
		circle.add(center);
		for (int i = 0; i < radius; i++)
			circle.addAll(HexagonalLocation.ring(center, i + 1));
		return circle;
	}
	
	public static ArrayList<HexagonalLocation> circleNoCenter(HexagonalLocation center, int radius) {
		ArrayList<HexagonalLocation> circle = new ArrayList<HexagonalLocation>();
		for (int i = 0; i < radius; i++)
			circle.addAll(HexagonalLocation.ring(center, i + 1));
		return circle;
	}
	
	public static ArrayList<HexagonalLocation> line(HexagonalLocation start, int length) {
		ArrayList<HexagonalLocation> line = new ArrayList<HexagonalLocation>();
		HexagonalLocation next = start;
		for (int i = 0; i < length; i++) {
			next = next.getNeighbor(Direction.SOUTH);
			line.add(next.clone());
		}
		return line;
	}
	
	public static ArrayList<HexagonalLocation> line(HexagonalLocation start, int length, Direction d) {
		ArrayList<HexagonalLocation> line = new ArrayList<HexagonalLocation>();
		HexagonalLocation next = start;
		for (int i = 0; i < length; i++) {
			next = next.getNeighbor(d);
			line.add(next.clone());
		}
		return line;
	}
	
	public static ArrayList<HexagonalLocation> rectangle(HexagonalLocation center, int width_radius, int height_radius) {
		ArrayList<HexagonalLocation> rectangle = new ArrayList<HexagonalLocation>();
		HexagonalLocation top = center.clone();
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
				rectangle.addAll(HexagonalLocation.line(top, height_radius * 2));
				top = top.getNeighbor(Direction.SOUTHEAST);
			} else {
				rectangle.addAll(HexagonalLocation.line(top, height_radius * 2 - 1));
				top = top.getNeighbor(Direction.NORTHEAST);
			}
			odd = !odd;
		}
		return rectangle;
	}
	
	public static ArrayList<HexagonalLocation> ring(HexagonalLocation center, int radius) {
		ArrayList<HexagonalLocation> ring = new ArrayList<HexagonalLocation>();
	
		HexagonalLocation hex = new HexagonalLocation(center.getX(), center.getY() + radius);
		for (int direction = 0; direction < 6; direction++)
			for (int i = 0; i < radius; i++) {
				ring.add(hex.clone());
				hex = hex.getNeighbor(direction);
			}
		return ring;
	}
	
	/** Rectilinear distance between two Hex coordinates. */
	public static int rectilinearDistance(HexagonalLocation a, HexagonalLocation b) {				
		return Math.max(Math.max(Math.abs(a.getU() - b.getU()),
				Math.abs(-a.getU() - a.getV() + b.getU() + b.getV())),
				Math.abs(a.getV() - b.getV()));
	}
	
	/** Stores uv axial coordinates. */
	public HexagonalLocation(int u, int v) {
		super(u, v);
	}

	public HexagonalLocation clone() {
		return new HexagonalLocation(getU(), getV());
	}
	
	/** Gets axial coordinates for potentially neighboring hex tiles. */
	@Override
	public HexagonalLocation getNeighbor(Direction d) {
		return getNeighbor(Direction.hexToInt(d));
	}
	
	/** Gets axial coordinates for potentially neighboring hex tiles. */
	@Override
	public HexagonalLocation getNeighbor(int d) {
		d = d % 6;
		if (d < 0)
			d += 6;
		switch (d) {
			case 0:
				return new HexagonalLocation(getU()+1, getV()-1);
			case 1:
				return new HexagonalLocation(getU(), getV()-1);
			case 2:
				return new HexagonalLocation(getU()-1, getV());
			case 3:
				return new HexagonalLocation(getU()-1, getV()+1);
			case 4:
				return new HexagonalLocation(getU(), getV()+1);
			case 5:
				return new HexagonalLocation(getU()+1, getV());
		}
		return null;
	}
	
	/** Returns axial coordinate u. */
	@Override
	public int getU() {
		return coordinate[0];
	}
	
	/** Returns axial coordinate v. */
	@Override
	public int getV() {
		return coordinate[1];
	}
	
	public boolean equals(HexagonalLocation other) {
		return (getU() == other.getU() && getV() == other.getV());
	}
	
	
	public String toString()
	{
		return this.getU() + " , " + this.getV();
	}
}
