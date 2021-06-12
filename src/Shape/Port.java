package Shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Port {
	// Properties
	private Shape parent;
	private boolean visible = false;
	private Point location;
	private int width = 10;
	private int height = 10;
	
	// Constructor
	public Port(Shape s, Point p) {
		parent = s;
		location = p;
	}
	
	// Methods
	public void draw(Graphics g) {
		int x = location.x;
		int y = location.y;
		
		if (visible) {
			g.setColor(Color.BLACK);
			g.fillRect(x, y, width, height);
		}
	}
	
	public void updateLocation(int delta_x, int delta_y) {
		location.x += delta_x;
		location.y += delta_y;
	}
	
	public int getCenterX() {
		return location.x + (width/2);
	}

	public int getCenterY() {
		return location.y + (height/2);
	}

	public void setVisible() {
		visible = true;
	}

	public void setUnVisible() {
		visible = false;
	}
}
