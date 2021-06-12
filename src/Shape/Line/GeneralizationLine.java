package Shape.Line;

import java.awt.Color;
import java.awt.Graphics;

import Shape.Port;

public class GeneralizationLine extends BasicLine {

	public GeneralizationLine(Port s, Port t) {
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
		int[] xpos = {x, x_pos[0], x_pos[1]};
		int[] ypos = {y, y_pos[0], y_pos[1]};
		
		g.setColor(new Color(238, 238, 238));
		g.fillPolygon(xpos, ypos, 3);
	    g.setColor(Color.BLACK);
	    g.drawPolygon(xpos, ypos, 3);
	}
}
