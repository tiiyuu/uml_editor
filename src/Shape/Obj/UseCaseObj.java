package Shape.Obj;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;

import Shape.Port;

public class UseCaseObj extends BasicObj {
	// Constructor
	public UseCaseObj(Point _location, int _depth) {
		super(_location, _depth);
		name = "Use Case";
		width = 150;
		height = 90;
		// Ports
		int x = location.x;
		int y = location.y;
		port[0] = new Port(this, new Point(x+(width-5)/2, y-5));
		port[1] = new Port(this, new Point(x+(width-5)/2, y+height-5));
		port[2] = new Port(this, new Point(x-5, y+(height-5)/2));
		port[3] = new Port(this, new Point(x+width-5, y+(height-5)/2));
	}

	// Methods
	@Override
	public void draw(Graphics g) {
		int x = location.x;
		int y = location.y;
		
		g.setColor(Color.BLACK);
		g.drawOval(x, y, width, height);
		
		// draw name in center
		Font font = g.getFont();
	    FontMetrics metrics = g.getFontMetrics(font);
	    int name_x = x + (width - metrics.stringWidth(name)) / 2;
	    int name_y = y + ((height - metrics.getHeight()) / 2) + metrics.getAscent();
	    g.drawString(name, name_x, name_y);
	    
	    if (selected) {
        	// Draw ports
        	for (int i = 0; i < port.length;i++) {
            	port[i].draw(g);
            }
        }
	}
	
	@Override
	public boolean isInside(Point p) {
		int x = p.x;
		int y = p.y;
		int a = width/2;
		int b = height/2;
		int h = location.x + a;
		int k = location.y + b;
		
		// Reference:
		// https://www.geeksforgeeks.org/check-if-a-point-is-inside-outside-or-on-the-ellipse/
		double check = ((Math.pow((x - h), 2) / Math.pow(a, 2))
	            		+ (Math.pow((y - k), 2) / Math.pow(b, 2)));
		
		if (check <= 1) {
			return true;
		}
		else {
			return false;
		}
	}
}
