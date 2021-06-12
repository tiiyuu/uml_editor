package UML_Editor;

import java.awt.*;
import javax.swing.*;

public class UML_Editor {
	// Properties
	private JFrame main_frame;
	private Canvas canvas;
	private TaskBar taskbar;
	private MenuBar menubar;
	
	// Constructor
	public UML_Editor() {
		canvas = Canvas.getInstance(); // Canvas is singleton 
		taskbar = TaskBar.getInstance();
		menubar = new MenuBar();
		
		main_frame = new JFrame();
		main_frame.getContentPane().setLayout(new BorderLayout());
		main_frame.getContentPane().add(menubar, BorderLayout.NORTH);
		main_frame.getContentPane().add(taskbar, BorderLayout.WEST);
		main_frame.getContentPane().add(canvas, BorderLayout.CENTER);
		
		main_frame.setTitle("UML editor");
		main_frame.setSize(800, 600);
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		mainWindow.setLocationRelativeTo(null);
		main_frame.setVisible(true);
	}
	
	// Main function
	public static void main(String[] args) {
		new UML_Editor();
	}
	
}
