package Model.Map.Grid;

import java.awt.Graphics;
import java.awt.Point;

import Model.Map.HexagonalLocation;

public interface DrawableHexGridInterface {
	
	public void drawHex(Graphics g, Point origin, HexagonalLocation hex,
			int grid_radius, int hexagon_size);
	
	public void drawRectangle(Graphics g, Point origin, HexagonalLocation hex,
			int grid_width_radius, int grid_height_radius, int hexagon_size);
	
	public void drawRectangleWithCoords(Graphics g, Point origin, HexagonalLocation hex,
			int grid_width_radius, int grid_height_radius, int hexagon_size);
	
}
