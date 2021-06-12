package Mode;

import java.awt.Point;

import Shape.Port;
import Shape.Shape;
import Shape.Line.AssociationLine;
import Shape.Line.CompositionLine;
import Shape.Line.GeneralizationLine;
import Shape.Obj.ClassObj;
import Shape.Obj.UseCaseObj;

public class ShapeFactory extends Mode {
	public Shape addNewObj(String obj, Point location, int depth) {
		if (obj == "Class") {
			return new ClassObj(location, depth);
		}
		else if (obj == "Use Case") {
			return new UseCaseObj(location, depth);
		}
		else {
			return null;
		}
	}
	
	public Shape addNewLine(String line, Port start, Port end) {
		if (line == "Association") {
			return new AssociationLine(start, end);
		}
		else if (line == "Composition") {
			return new CompositionLine(start, end);
		}
		else if (line == "Generalization") {
			return new GeneralizationLine(start, end);
		}
		else {
			return null;
		}
	}
}
