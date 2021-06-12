package Shape.Line;

import java.awt.Color;
import java.awt.Graphics;

import Shape.Port;

public class AssociationLine extends BasicLine {
	
	public AssociationLine(Port s, Port t) {
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
		g.drawLine(x, y, x_pos[0], y_pos[0]);
		g.drawLine(x, y, x_pos[1], y_pos[1]);
	}
}
