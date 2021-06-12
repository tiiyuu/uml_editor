package Mode;

import java.awt.event.MouseEvent;

import Shape.Shape;
import Shape.Obj.ClassObj;

public class AddNewObjMode extends Mode {
	// Properties
	ShapeFactory factory = new ShapeFactory(); // Factory method pattern
	String obj_type;
	
	// Constructor
	public AddNewObjMode(String type) {
		obj_type = type;
	}
	
	// Methods
	@Override
	public void mousePressed(MouseEvent e) {
		Shape shape = factory.addNewObj(obj_type, e.getPoint(), canvas.getDepth());
		canvas.addDepth();
		canvas.addShape(shape);
		canvas.repaint();
	}
}
