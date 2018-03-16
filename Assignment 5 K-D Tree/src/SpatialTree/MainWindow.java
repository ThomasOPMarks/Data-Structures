package SpatialTree;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainWindow extends JFrame {
	//This is the window in the driver
	public MainWindow(ArrayList<Point> points, int width, int height, String name){
		//This names the window Drawing window, and calls the JFrame constructor
		super(name);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(width,height);
		
		//This adds a canvas, which will handle drawing all the rectangles in the tree.
		this.setLayout(new BorderLayout());
		Canvas canvas = new Canvas(points, width, height);
		
		
		add(canvas, BorderLayout.CENTER);
		
		setVisible(true);
	}

}
