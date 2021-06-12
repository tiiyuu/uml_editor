package Shape.Obj;

import java.awt.Point;
import Shape.Port;
import Shape.Shape;

public class BasicObj extends Shape {
	// Properties
	protected String name;
	protected Port[] port = new Port[4]; // 0:top, 1:bottom, 2:left, 3:right
	
	// Constructor
	public BasicObj(Point _location, int _depth) {
		location = _location;
		depth = _depth;
	}
	
	@Override
	public void setSelected() {
		selected = true;
		for (int i = 0; i < port.length; i++) {
			port[i].setVisible();
		}
	}
	
	@Override
	public void setUnSelected() {
		selected = false;
		for (int i = 0; i < port.length; i++) {
			port[i].setUnVisible();
		}
	}
	
	@Override
	public boolean isInsideRectangle(Point start, Point end) {
		if (start.x <= location.x && location.x + width <= end.x) {
			if (start.y <= location.y && location.y + height <= end.y) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void updateLocation(int delta_x, int delta_y) {
		super.updateLocation(delta_x, delta_y);
		for (int i = 0; i < port.length; i++) {
			port[i].updateLocation(delta_x, delta_y);
		}
	}
	
	public void setName(String _name) {
		name = _name;
	}
	
	public void setLocation(Point p) {
		location = p;
	}
	
	// Get which port is the nearest to the mouse click point
	public Port getConnectPort(Point p) {
		Port currentPort, nearest = null;
		double temp, shortest = Double.MAX_VALUE;
		
		for (int i = 0; i < port.length; i++) {
			currentPort = port[i];
			temp = Math.sqrt(Math.abs(Math.pow(p.x - currentPort.getCenterX(), 2) + Math.pow(p.y - currentPort.getCenterY(), 2)));
			if (temp < shortest) {
				shortest = temp;
				nearest = currentPort;
			}
		}
		
		return nearest;
	}
}
