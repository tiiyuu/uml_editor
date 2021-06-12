package Mode;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Shape.Shape;


public class SelectMode extends Mode {
	Point rect_start = null, rect_end = null;
	ArrayList<Shape> selected = new ArrayList<Shape>();
	Point move_center = null;
	
	@Override
	public void mousePressed(MouseEvent e) {
		Shape shape = canvas.getClickedObj(e.getPoint());
		
		if (shape == null) {
			rect_start = e.getPoint();
			move_center = null;
			canvas.reset();
		}
		else {
			rect_start = null;
			move_center = e.getPoint();
			
			if (!shape.isSelected()) {
				canvas.reset();
				shape.setSelected();
				canvas.repaint();
			}
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		canvas.selectObjInRectangle();
		canvas.clearRectangle();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// Show Rectangle
		if (rect_start != null) {
			rect_end = e.getPoint();
			canvas.setRectangle(rect_start, rect_end);
		}
		
		// Move Selected objs
		if (move_center != null) {
			int delta_x = e.getX() - move_center.x;
			int delta_y = e.getY() - move_center.y;
			move_center = e.getPoint(); // update center after mouse dragged
			// Move objs
			selected = canvas.getSelectedObj();
			for (int i = 0; i < selected.size(); i++) {
				selected.get(i).updateLocation(delta_x, delta_y);
			}
			canvas.repaint();
		}
	}
}
