package Shape.Line;

import Shape.Port;
import Shape.Shape;

public class BasicLine extends Shape {
	// Properties
	protected Port source, target;
	
	// Constructor
	public BasicLine(Port s, Port t) {
		source = s;
		target = t;
	}
	
	// Methods
	public int[][] getArrowLocation() {
		int x1 = source.getCenterX(), y1 = source.getCenterY();
		int x2 = target.getCenterX(), y2 = target.getCenterY();
		int d = 10, h = 10;
		int dx = x2 - x1, dy = y2 - y1;
	    double D = Math.sqrt(dx*dx + dy*dy);
	    double xm = D - d, xn = xm, ym = h, yn = -h, x;
	    double sin = dy / D, cos = dx / D;
	    x = xm*cos - ym*sin + x1;
	    ym = xm*sin + ym*cos + y1;
	    xm = x;
	    x = xn*cos - yn*sin + x1;
	    yn = xn*sin + yn*cos + y1;
	    xn = x;
	    int[] x_pos = {(int) xm, (int) xn};
	    int[] y_pos = {(int) ym, (int) yn};
	    int[][] XY = {x_pos, y_pos};
	    
	    return XY;
	}
}
