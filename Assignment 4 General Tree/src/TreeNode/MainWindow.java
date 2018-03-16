package TreeNode;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainWindow extends JFrame {
	//This is the window in the driver
	public MainWindow(){
		//This names the window Drawing window, and calls the JFrame constructor
		super("Drawing Windows");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,800);
		
		//This adds a canvas, which will handle drawing all the rectangles in the tree.
		this.setLayout(new BorderLayout());
		Canvas canvas = new Canvas();
		
		
		add(canvas, BorderLayout.CENTER);
		
		setVisible(true);
	}

}
