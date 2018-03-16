package TreeNode;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import TreeNode.RectangleTree.TreeNode;

public class Canvas extends JPanel implements MouseListener{
	//All the variables that will be used here, for the mouse events as well as a tree and a reference to the tree's root
	private RectangleTree tree;
	private TreeNode root;
	private Point mouseStart;
	private Point mouseStop;
	

	// Constructor for the canvas, calls the super (for the jPanel, because it extends it)
	public Canvas(){
		super();
		tree = new RectangleTree();
		root = tree.root;
		addMouseListener(this);
		
	}
	
	
	
	//a method that paints the whole tree, by iteratoring over a snapshot of the tree after the tree changes.
	@Override
	public void paint(Graphics g){
	
		ArrayList<TreeNode> list = new ArrayList<>();
		list = snapshot(list, root);
		for (int i = 0; i < list.size(); i++){
			if(list.get(i).parent == null){
				g.setColor(Color.WHITE);
			}
			else{
				g.setColor(list.get(i).parent.color);
			}
			g.fillRect(list.get(i).rect.x, list.get(i).rect.y, list.get(i).rect.width, list.get(i).rect.height);
		}
		
	}
	
	//Makes a snapshot of the tree, so the tree can be drawn. It does a depth first add, but it draws them properly due to the nature
	//Of the tree and the lack of intersections 
	private ArrayList<TreeNode> snapshot(ArrayList<TreeNode> list, TreeNode n){
		list.add(n);
		for(int i = 0; i < n.children.size(); i++){
			snapshot(list, n.children.get(i));
		}
		return list;
	}
	
	

	//Many unused ouse mehtods here
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
		if( SwingUtilities.isRightMouseButton(e)){
			tree.remove(mouseStop);
		}
		if(SwingUtilities.isLeftMouseButton(e)){
			Rectangle rect = new Rectangle(Math.min(mouseStart.x,mouseStop.x), Math.min(mouseStart.y, mouseStop.y), 
					Math.abs(mouseStop.x - mouseStart.x),Math.abs(mouseStop.y - mouseStart.y));
			 tree.addChild(rect);
		}
		
		repaint();
		
		
		
	}
}
