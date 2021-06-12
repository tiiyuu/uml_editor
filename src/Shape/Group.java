package Shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Vector;

public class Group extends Shape {
	// Properties
	private ArrayList<Shape> group_members = new ArrayList<Shape>();
	
	// Constructor
	public Group(ArrayList<Shape> selected_objs, int _depth) {
		// System.out.println("Create Group Obj");
		depth = _depth;
		group_members = selected_objs;
		selected = true;
		setRange();
	}
	
	// Methods
	private void setRange() {
		int temp;
		int min_x = Integer.MAX_VALUE, min_y = Integer.MAX_VALUE;
		int max_x = Integer.MIN_VALUE, max_y = Integer.MIN_VALUE;
		
		for (int i = 0; i < group_members.size(); i++) {
			Shape obj = group_members.get(i);

			temp = obj.getLocation().x;
			if (temp < min_x) {
				min_x = temp;
			}
			
			temp = obj.getLocation().x + obj.getWidth();
			if (temp > max_x) {
				max_x = temp;
			}
			
			temp = obj.getLocation().y;
			if (temp < min_y) {
				min_y = temp;
			}
			
			temp = obj.getLocation().y + obj.getHeight();
			if (temp > max_y) {
				max_y = temp;
			}
		}
		
		location = new Point(min_x, min_y);
		width = max_x - min_x;
		height = max_y - min_y;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		// Draw members
		for (int i = 0; i < group_members.size(); i++) {
			group_members.get(i).draw(g);
		}
		g.drawRect(location.x, location.y, width, height);
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
	
	@Override
	public void setSelected() {
		selected = true;
		for (int i = 0; i < group_members.size(); i++) {
			group_members.get(i).setSelected();
		}
	}
	
	@Override
	public void setUnSelected() {
		selected = false;
		for (int i = 0; i < group_members.size(); i++) {
			group_members.get(i).setUnSelected();
		}
	}
	
	@Override
	public boolean isInsideRectangle(Point start, Point end) {
		if (start.x <= location.x && location.x + width <= end.x) {
			if (start.y <= location.y && location.y + height <= end.y) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void updateLocation(int delta_x, int delta_y) {
		super.updateLocation(delta_x, delta_y);
		for (int i = 0; i < group_members.size(); i++) {
			group_members.get(i).updateLocation(delta_x, delta_y);
		}
	}
	
	public ArrayList<Shape> getGroupMembers() {
		return group_members;
	}
}
