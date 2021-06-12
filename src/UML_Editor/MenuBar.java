package UML_Editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
	private Canvas canvas;
	private JMenu file;
	private JMenu edit;
	
	public MenuBar() {
		canvas = Canvas.getInstance();
		
		// Menu "File":
		file = new JMenu("File");
		// Items in "File"
        JMenuItem no = new JMenuItem("(¡ó_¡ó)¡H");
        file.add(no);
        // Add "File" to MenuBar
        add(file);
        
        // Menu "Edit":
        edit = new JMenu("Edit");
        
        // Group Obj
        JMenuItem group = new JMenuItem("Group");
        edit.add(group);
        group.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.groupObj();
			}
        });
        
        // Ungroup Obj
        JMenuItem ungroup = new JMenuItem("Ungroup");
        edit.add(ungroup);
        ungroup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.ungroupObj();
			}
        });
        
        // Change Obj Name
        JMenuItem change_name = new JMenuItem("Change Object Name");
        edit.add(change_name);
        change_name.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new InputWindow();
			}
        });
        // Add "Edit" to MenuBar
        add(edit);
	}
}
