package UML_Editor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Mode.Mode;

public class Button extends JButton {
	// Properties
	private TaskBar taskBar;
	private Canvas canvas;
	Mode mode;
	
	// Constructor
	public Button(String btn_name, Mode _mode) {
		canvas = Canvas.getInstance();
		mode = _mode;
		setText(btn_name);
		
		addActionListener (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println(btn.getText());
				setSelected();
				canvas.reset();
				canvas.setMode(mode);
			}
        });
	}
	
	// Methods
	private void setSelected() {
		taskBar = TaskBar.getInstance();
		taskBar.resetAllButton();
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
	}
	
}
