package UML_Editor;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComponent;

import Mode.Mode;
import Shape.Group;
import Shape.Shape;

public class Canvas extends JComponent {
	// Properties
	private static Canvas instance = null; // Singleton
	private Mode current_mode = null;
	private int current_depth = 0;
	private Rectangle r = null;
	private ArrayList<Shape> all_shapes = new ArrayList<Shape>();

	// private for Singleton
	private Canvas() {
		
	}
	
	// Methods
	public static Canvas getInstance() {
		if (instance == null) {
			instance = new Canvas();
		}
		return instance;
	}

	@Override
	public void paint(Graphics g) { // Automatically called by "repaint()"
		for (int i = 0; i < all_shapes.size(); i++) {
			all_shapes.get(i).draw(g);
		}
		
		if (r != null) {
			r.draw(g);
		}
	}
	
	public void groupObj() {
		// System.out.println("Group");
		// System.out.println(all_selected_shapes);
		// System.out.println(all_shapes);
		ArrayList<Shape> selected = getSelectedObj();
		if (selected.size() > 1) {
			Shape shape = new Group(selected, current_depth);
			all_shapes.add(shape);
			current_depth++;
			all_shapes.removeAll(selected);
			repaint();
		}
		// System.out.println(all_shapes);
	}
	
	public void ungroupObj() {
		// System.out.println("Ungroup");
		ArrayList<Shape> selected = getSelectedObj();
		ArrayList<Shape> members = new ArrayList<Shape>();
		ArrayList<Shape> groups = new ArrayList<Shape>();
		
		// Only 1 group obj is selected
		if (selected.size() == 1 && selected.get(0).getGroupMembers() != null) {
			groups.add(selected.get(0));
			members.addAll(selected.get(0).getGroupMembers());
			all_shapes.removeAll(groups);
			all_shapes.addAll(members);
			repaint();
		}
	}

	public void changeObjName(String name) {
		// System.out.println("Change Name");
		ArrayList<Shape> selected = getSelectedObj();
		if (selected.size() == 1) {
			selected.get(0).setName(name);
			repaint();
		}
	}
	
	public ArrayList<Shape> getSelectedObj() {
		ArrayList<Shape> selected = new ArrayList<Shape>();
		for (int i = 0; i < all_shapes.size(); i++) {
			Shape shape = all_shapes.get(i);
			if (shape.isSelected()) {
				selected.add(shape);
			}
		}
		return selected;
	}
	
	public void setMode(Mode mode) {
		removeMouseListener(current_mode);
		removeMouseMotionListener(current_mode);
		current_mode = mode;
		addMouseListener(current_mode);
		addMouseMotionListener(current_mode);
	}
	
	public Mode getCurrentMode() {
		return current_mode;
	}
	
	public void addShape(Shape shape) {
		all_shapes.add(shape);
	}
	
	public int getDepth() {
		return current_depth;
	}
	
	public void addDepth() {
		current_depth++;
	}
	
	public void setRectangle(Point start, Point end) {
		r = new Rectangle();
		r.setRectangle(start, end);
		repaint();
	}
	
	public void clearRectangle() {
		r = null;
		repaint();
	}
	
	public Shape getClickedObj(Point p) {
		int min = Integer.MAX_VALUE, temp, min_object_index = 0;
		Shape shape = new Shape();
		Vector<Shape> candidates = new Vector<Shape>();
		
		// Get all clicked shapes
		for (int i = 0; i < all_shapes.size(); i++) {
			shape = all_shapes.get(i);
			if (shape.isInside(p)) {
				candidates.add(shape);
			}
		}
		
		// Chose the top one by depth
		if (candidates.size() != 0 ) {
			// Find shape having minimum depth
			for (int i = 0; i < candidates.size(); i++) {
				temp = candidates.get(i).getDepth();
				if (temp < min) {
					min = temp;
					min_object_index = i;
				}
			}
			// System.out.println(candidates.get(min_object_index));
			return candidates.get(min_object_index);
		}
		else {
			return null;
		}
	}
	
	public void selectObjInRectangle() {
		if (r != null) {
			Shape shape = new Shape();
			for (int i = 0; i < all_shapes.size(); i++) {
				shape = all_shapes.get(i);
				if (shape.isInsideRectangle(r.getStartLocation(), r.getEndLocation())) {
					shape.setSelected();
					// System.out.println(all_selected_shapes);
				}
			}
			repaint();
		}
	}
	
	public void reset() {
		for (int i = 0; i < all_shapes.size(); i++) {
			Shape shape = all_shapes.get(i);
			shape.setUnSelected();
		}
		repaint();
	}
}
