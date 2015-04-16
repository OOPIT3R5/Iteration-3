package Model.Map;


/**
 * 
 * @author Jack
 *
 */
public class RectangularLocation extends Location implements RectangularCoordinateInterface /*implements Comparable<Vector2D>*/ {
	
	public RectangularLocation(int x, int y) {
		super(x, y);
	}
	
	@Override
	public int getX() {
		return coordinate[0];
	}

	@Override
	public int getY() {
		return coordinate[1];
	}

	@Override
	public RectangularLocation getNeighbor(int d) {
		d = d % 6;
		if (d < 0)
			d += 6;
		switch (d) {
			case 0:
				return new RectangularLocation(getX() + 1, getY() - 1);
			case 1:
				return new RectangularLocation(getX(), getY() - 1);
			case 2:
				return new RectangularLocation(getX() - 1, getY());
			case 3:
				return new RectangularLocation(getX() - 1, getY() + 1);
			case 4:
				return new RectangularLocation(getX(), getY() + 1);
			case 5:
				return new RectangularLocation(getX() + 1, getY());
		}
		return null;
	}
	
	@Override
	public RectangularLocation getNeighbor(Direction d) {
		return getNeighbor(Direction.octToInt(d));
	}
	
	/*public double angle() {
		return angleBetween(this, new Vector2D(1,0));
	}
	
	@Override
	public int compareTo(Vector2D other) {
		double difference = this.magnitude() - other.magnitude();
		if (difference < 0)
			return -1;
		else if (difference > 0)
			return 1;
		return 0;
	}
	
	public double magnitude() {
		return Math.sqrt(vector[0] ^ 2 + vector[1] ^ 2);
	}
	
	public Vector2D add(Vector2D other) {
		return new Vector2D(vector[0] + other.vector[0], vector[1] + other.vector[1]);
	}
	
	public Vector2D subtract(Vector2D other) {
		return new Vector2D(vector[0] - other.vector[0], vector[1] - other.vector[1]);
	}
	
	public static VectorPoint2D add(VectorPoint2D a, VectorPoint2D b) {
		return new VectorPoint2D(a.vector[0] + b.vector[0], a.vector[0] + b.vector[0]);
	}

	public static double angleBetween(Vector2D a, Vector2D b) {
		return dot(a, b) / (a.magnitude() * b.magnitude());
	}
	
	public static double distance(VectorPoint2D a, VectorPoint2D b) {
		return VectorPoint2D.subtract(a, b).magnitude();
	}
	
	public static int dot(Vector2D a, Vector2D b) {
		return a.vector[0] * b.vector[0] + a.vector[1] * b.vector[1];
	}
	
	public static VectorPoint2D scale(VectorPoint2D a, int scalar) {
		return new VectorPoint2D(a.vector[0] * scalar, a.vector[1] * scalar);
	}
	
	public static VectorPoint2D subtract(VectorPoint2D a, VectorPoint2D b) {
		return new VectorPoint2D(a.vector[0] - b.vector[0], a.vector[0] - b.vector[0]);
	}*/
	
}
