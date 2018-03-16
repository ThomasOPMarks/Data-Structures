package SpatialTree;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Canvas extends JPanel implements MouseListener{
	//All the variables that will be used here, for the mouse events as well as a tree and a reference to the tree's root
	private SpatialTree tree;
	private Printable root;
	private Point mouseStart;
	private Point mouseStop;
	private double radius;
	private int width;
	private int height;
	private int visited;
	

	// Constructor for the canvas, calls the super (for the jPanel, because it extends it)
	public Canvas(ArrayList<Point> points, int width, int height){
		super();
		mouseStart = new Point(0,0);
		mouseStop = new Point(0,0);
		radius = 0;
		tree = new SpatialTree(points, new Rectangle(width, height));
		root = tree.getRoot();
		addMouseListener(this);
		this.width = width;
		this.height = height;
	}
	
	
	
	//a method that paints the whole tree, by iteratoring over a snapshot of the tree after the tree changes.
	@Override
	public void paint(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		ArrayList<Printable> list = new ArrayList<>();
		list = snapshot(list, root);
		//System.out.println("Here is the size of the snapshot: " + list.size());
		Printable current;
		for (int i = 0; i < list.size(); i++){
			//System.out.print(i + " ");
			
			current = list.get(i);
			//System.out.println(current);
			if(current.getType()){
				g.setColor(Color.BLUE);
				g.drawLine((int)current.getLine().x1, (int)current.getLine().y1,(int) current.getLine().x2, (int)current.getLine().y2);
			}
			else{
				g.setColor(Color.RED);
				g.drawLine((int)current.getLine().x1,(int) current.getLine().y1,(int) current.getLine().x2,(int) current.getLine().y2);
			}
			
		}
		
		g.setColor(Color.GREEN);
		ArrayList<Printable> closeDots = new ArrayList<>();
		visited = 0;
		closeDots = tree.query(mouseStart, radius, closeDots, root);
		//System.out.println("Size of snapshot:" + closeDots.size());
		for(Printable p : closeDots){
			g.fillOval(p.getPoint().x - 5, p.getPoint().y -5 , 10, 10);
		}
		System.out.println("Tree nodes visited: " + tree.visited);
		
	}
	
	//Makes a snapshot of the tree, so the tree can be drawn. It does a depth first add, but it draws them properly due to the nature
	//Of the tree and the lack of intersections 
	//This has a run time of O(n)
	private ArrayList<Printable> snapshot(ArrayList<Printable> list, Printable n){
		list.add(n);
		if(n.getSmaller() != null){
			snapshot(list, n.getSmaller());
		}
		if(n.getBigger() != null){
			snapshot(list, n.getBigger());
		}
		return list;
	}
	
	
	
	
	//Many unused mouse methods here
	@Override
	public void mouseClicked(MouseEvent e) {
		//Do nothing
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//Do nothing
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//Do nothing
		
	}
	
	
	//When the mouse is pressed it is important to get the location of the press, so we can draw the rectangle later
	@Override
	public void mousePressed(MouseEvent e) {
		mouseStart = e.getPoint();
		
	}
	
	
	//When the mouse is released, if it is the left a rectangle is added if it is possible, otherwise a right click results in the removal of it
	@Override
	public void mouseReleased(MouseEvent e) {
		mouseStop = e.getPoint();
		radius = Math.sqrt((mouseStop.getX() - mouseStart.getX()) * (mouseStop.getX() - mouseStart.getX()) + (mouseStop.getY() - mouseStart.getY()) * (mouseStop.getY() - mouseStart.getY()) );
		
		/*System.out.println(mouseStart.toString());
		System.out.println(mouseStop.toString());
		System.out.println(radius);*/
		
		
		//TODO Search after this and highlight
		
		repaint();
		
		
		
	}
	

	
}
