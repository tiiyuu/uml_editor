package Shape.Obj;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;

import Shape.Port;

public class ClassObj extends BasicObj {
	// Constructor
	public ClassObj(Point _location, int _depth) {
		super(_location, _depth);
		name = "Class";
		width = 120;
		height = 150;
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
        g.drawRect(x, y, width, height);
        g.drawLine(x, y + (height/3), x + width, y + (height/3));
        g.drawLine(x, y + 2*(height/3), x + width, y + 2*(height/3));
        
        // Draw name in center
        // Reference: https://stackoverflow.com/questions/27706197/how-can-i-center-graphics-drawstring-in-java
        Font font = g.getFont();
        FontMetrics metrics = g.getFontMetrics(font);
        int name_x = x + (width - metrics.stringWidth(name)) / 2;
        int name_y = y + ((height/3 - metrics.getHeight()) / 2) + metrics.getAscent();
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
		
		if (location.x <= x && x <= location.x + width) {
			if (location.y <= y && y <= location.y + height) {
				return true;
			}
		}
		return false;
	}
}
