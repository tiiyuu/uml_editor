package Shape;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Vector;

public class Shape {
	protected boolean selected = false;
	protected Point location = null;
	protected int width, height;
	protected int depth = Integer.MAX_VALUE;
	
	public void draw(Graphics g) {}
	
	public Point getLocation() {
		return location;
	}
	
	public void updateLocation(int delta_x, int delta_y) {
		location.x += delta_x;
		location.y += delta_y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public void setSelected() {
		selected = true;
	}
	
	public void setUnSelected() {
		selected = false;
	}
	
	public boolean isSelected() {
		return selected;
	}

	public boolean isInside(Point p) {
		return false;
	}

	public boolean isInsideRectangle(Point start, Point end) {
		return false;
	}

	public Port getConnectPort(Point point) {
		return null;
	}

	public ArrayList<Shape> getGroupMembers() {
		return null;
	}

	public void setName(String string) {
		
	}
}
