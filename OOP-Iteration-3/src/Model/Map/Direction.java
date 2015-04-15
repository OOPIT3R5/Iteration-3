package Model.Map;


/**
 * Directional enum for the cardinal and ordinal directions:
 * North, Northeast, East, Southeast, South, Southwest,
 * West, and Northwest.
 * 
 * @author Jack
 */
public enum Direction {

	NORTH,
	NORTHEAST,
	EAST,
	SOUTHEAST,
	SOUTH,
	SOUTHWEST,
	WEST,
	NORTHWEST;
	
	public static int hexToInt(Direction d) {
		switch (d) {
			case NORTHEAST:
				return 0;
			case NORTH:
				return 1;
			case NORTHWEST:
				return 2;
			case SOUTHWEST:
				return 3;
			case SOUTH:
				return 4;
			case SOUTHEAST:
				return 5;
			default:
				return -1;
		}
	}
	
	public static int octToInt(Direction d) {
		switch (d) {
			case EAST:
				return 0;
			case NORTHEAST:
				return 1;
			case NORTH:
				return 2;
			case NORTHWEST:
				return 3;
			case WEST:
				return 4;
			case SOUTHWEST:
				return 5;
			case SOUTH:
				return 6;
			case SOUTHEAST:
				return 7;
			default:
				return -1;
		}
	}

}
