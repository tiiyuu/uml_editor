package Shape.Line;

import java.awt.Color;
import java.awt.Graphics;

import Shape.Port;

public class CompositionLine extends BasicLine {

	public CompositionLine(Port s, Port t) {
		super(s, t);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		
		// Line
        g.drawLine(source.getCenterX(), source.getCenterY(), target.getCenterX(), target.getCenterY());
        
        // Arrow
        int x = target.getCenterX();
		int y = target.getCenterY();
		int[][] XY = getArrowLocation();
		int[] x_pos = XY[0];
		int[] y_pos = XY[1];
		int middle_x = (x_pos[0] + x_pos[1])/2;
		int middle_y = (y_pos[0] + y_pos[1])/2;
		int delta_x = middle_x - x;
		int delta_y = middle_y - y;
		int x2 = x + 2*delta_x;
		int y2 = y + 2*delta_y;
		
		int[] xpos = {x, x_pos[0], x2, x_pos[1]};
		int[] ypos = {y, y_pos[0], y2, y_pos[1]};
		
		g.setColor(new Color(238, 238, 238));
		g.fillPolygon(xpos, ypos, 4);
	    g.setColor(Color.BLACK);
	    g.drawPolygon(xpos, ypos, 4);
	}
}
