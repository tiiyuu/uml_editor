package Mode;

import java.awt.event.MouseEvent;

import Shape.Port;
import Shape.Shape;

public class AddNewLineMode extends Mode {
	// Properties
	ShapeFactory factory = new ShapeFactory(); // Factory method pattern
	String line_type;
	Shape s, t;
	Port source = null, target = null;

	// Constructor
	public AddNewLineMode(String type) {
		line_type = type;
	}
	
	// Methods
	@Override
	public void mousePressed(MouseEvent e) {
		s = canvas.getClickedObj(e.getPoint());
		if (s != null) {
			source = s.getConnectPort(e.getPoint());
		}
		else {
			source = null;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		t = canvas.getClickedObj(e.getPoint());
		if (t != null) {
			target = t.getConnectPort(e.getPoint());
		}
		else {
			target = null;
		}
		
		if (source != null && target != null && s != t) {
			Shape shape = factory.addNewLine(line_type, source, target);
			canvas.addShape(shape);
			canvas.repaint();
		}
	}
}
