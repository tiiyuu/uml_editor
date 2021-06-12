package UML_Editor;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputWindow {
	private Canvas canvas = Canvas.getInstance();
	
	public InputWindow() {
		JFrame frame = new JFrame("Change Object Name");
        JPanel input_panel = new JPanel();
        JTextField input_area = new JTextField(20);
        JButton enter_btn = new JButton("Enter");
        JButton cancel_btn = new JButton("Cancel");
        input_panel.add(input_area);
        input_panel.add(enter_btn);
        input_panel.add(cancel_btn);
        frame.add(input_panel);
        frame.setPreferredSize(new Dimension(400, 80));
        frame.pack();
        frame.setVisible(true);
        
        enter_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input_text = input_area.getText();
                // System.out.println(input_text);
                canvas.changeObjName(input_text);
                frame.dispose();
            }
        });
        
        cancel_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        
        input_area.addKeyListener(new KeyListener() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		 // System.out.println(e);
        		 // Press Enter
        		 if (e.getKeyCode() == 10 && !input_area.getText().isEmpty()) {
        			 String input_text = input_area.getText();
        			 canvas.changeObjName(input_text);
                     frame.dispose();
        		 }
              }

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
	}
}
