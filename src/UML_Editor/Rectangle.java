package UML_Editor;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;

public class Rectangle {
	// Properties
	private Point start_location, end_location;
	private int width;
	private int height;
	
	// Methods
	public Point getStartLocation() {
		return start_location;
	}
	
	public Point getEndLocation() {
		return end_location;
	}
	
	public void setRectangle(Point start, Point end) {
		start_location = new Point(start.x, start.y);
		if (end.x <= start.x && end.y <= start.y ) {
			start_location = new Point(end.x, end.y);
		}
		else if (end.x <= start.x) {
			start_location = new Point(end.x, start.y);
		}
		else if (end.y <= start.y) {
			start_location = new Point(start.x, end.y);
		}
		width = Math.abs(start.x - end.x);
		height = Math.abs(start.y - end.y);
		end_location = new Point(start_location.x + width, start_location.y + height);
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		Graphics2D g2D = (Graphics2D) g;
		Rectangle2D rect = new Rectangle2D.Float(start_location.x, start_location.y, width, height);
		float[] dash = { 5F, 5F };
		Stroke dashedStroke = new BasicStroke( 2F, BasicStroke.CAP_SQUARE,
		BasicStroke.JOIN_MITER, 3F, dash, 0F );
		g2D.fill(dashedStroke.createStrokedShape(rect));
	}
}
