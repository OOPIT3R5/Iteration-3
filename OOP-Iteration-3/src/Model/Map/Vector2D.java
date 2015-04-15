package Model.Map;


/**
 * 
 * @author Jack
 *
 */
public class Vector2D implements Comparable<Vector2D> {
	
	/*public static VectorPoint2D add(VectorPoint2D a, VectorPoint2D b) {
		return new VectorPoint2D(a.vector[0] + b.vector[0], a.vector[0] + b.vector[0]);
	}*/

	public static double angleBetween(Vector2D a, Vector2D b) {
		return dot(a, b) / (a.magnitude() * b.magnitude());
	}
	
	/*public static double distance(VectorPoint2D a, VectorPoint2D b) {
		return VectorPoint2D.subtract(a, b).magnitude();
	}*/
	
	public static int dot(Vector2D a, Vector2D b) {
		return a.vector[0] * b.vector[0] + a.vector[1] * b.vector[1];
	}
	
	/*public static VectorPoint2D scale(VectorPoint2D a, int scalar) {
		return new VectorPoint2D(a.vector[0] * scalar, a.vector[1] * scalar);
	}
	
	public static VectorPoint2D subtract(VectorPoint2D a, VectorPoint2D b) {
		return new VectorPoint2D(a.vector[0] - b.vector[0], a.vector[0] - b.vector[0]);
	}*/
	
	private final int[] vector = new int[2];
	
	public Vector2D(int x, int y) {
		vector[0] = x;
		vector[1] = y;
	}
	
	public double angle() {
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
	
	public int getX() {
		return vector[0];
	}
	
	public int getY() {
		return vector[1];
	}
	
	public Vector2D getNeighbor(int d) {
		d = d % 6;
		if (d < 0)
			d += 6;
		switch (d) {
			case 0:
				return new Vector2D(getX() + 1, getY() - 1);
			case 1:
				return new Vector2D(getX(), getY() - 1);
			case 2:
				return new Vector2D(getX() - 1, getY());
			case 3:
				return new Vector2D(getX() - 1, getY() + 1);
			case 4:
				return new Vector2D(getX(), getY() + 1);
			case 5:
				return new Vector2D(getX() + 1, getY());
		}
		return null;
	}
	
	public Vector2D getNeighbor(Direction d) {
		return getNeighbor(Direction.octToInt(d));
	}
	
}
