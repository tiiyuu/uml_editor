package UML_Editor;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Mode.*;

public class TaskBar extends JPanel {
	// Properties
	private static TaskBar instance = null; // Singleton
    private Button btn[] = new Button[6];
    
    // Constructor
	private TaskBar() {
		// Set 6 buttons
		btn[0] = new Button("Select", new SelectMode());
	    btn[1] = new Button("Association", new AddNewLineMode("Association"));
	    btn[2] = new Button("Generalization", new AddNewLineMode("Generalization"));
	    btn[3] = new Button("Composition", new AddNewLineMode("Composition"));
	    btn[4] = new Button("Class", new AddNewObjMode("Class"));
	    btn[5] = new Button("Use Case", new AddNewObjMode("Use Case"));
	    
	    setLayout(new GridLayout(btn.length, 0));
	    
	    for (int i = 0; i < btn.length; i++) {
	    	 add(btn[i]); // add to TaskBar
	    }
	}

	public static TaskBar getInstance() {
		if (instance == null) {
			instance = new TaskBar();
		}
		return instance;
	}
	
	public void resetAllButton() {
		for (int i = 0; i < btn.length; i++) {
			btn[i].setBackground(null);
			btn[i].setForeground(null);
	    }
	}
	
}
