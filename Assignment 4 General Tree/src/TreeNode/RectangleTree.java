package TreeNode;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class RectangleTree {
	//The class that mainly deals with the tree, and all the searching, adding, and removing
	
	//This has a reference to a root of the tree.
	protected TreeNode root;
	
	
	//Initializes the root to the size of the MainWindow, so it covers the whole screen. The parent is null
	public RectangleTree(){
		root = new TreeNode(new Rectangle(800, 800), null);
	}
	
	//The tree node. This is trusting of the user because it is only protected
	public class TreeNode implements Position{
		//Has a rectangle, the color OF ITS CHILDREN, an arraylist of the children, and the parent of the node
		protected Rectangle rect;
		protected Color color;
		protected ArrayList<TreeNode> children;
		protected TreeNode parent;
		
		//Here the tree is initialized by passing a rectangle and the parent of the tree.
		public TreeNode(Rectangle rect, TreeNode p){
			Random r = new Random();
			parent = p;
			this.rect = rect;
			children = new ArrayList<>();
			color = (new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
		}
	}
		
	//Recursively looks for the smallest rectangle that contains the point. This is used in most methods
		private  TreeNode lookForPoint(Point p, TreeNode n){
			boolean kidHasPoint = false;
			TreeNode choosenKid = null;
			for(int i = 0; i < n.children.size(); i++){
				if(n.children.get(i).rect.contains(p)){
					kidHasPoint = true;
					choosenKid = n.children.get(i);
					
				}
			}
			
			if(kidHasPoint){
				return lookForPoint(p, choosenKid);
			}
			else{
				return n;
			}
		}
		
		//Gets the smallest rectangle that has this point
		public TreeNode getContainer(Point p){
			return lookForPoint(p, root);
		}
		
		//Gets the smallest rectangle that fully contains the point, by looking for the smallest rectangle that fully contains each
		// of the points of the rectangle. If these are different that means the rectangle intersects and null is returned. 
		public TreeNode getFullyContainingRectangle(Rectangle r){
			TreeNode t1 = getContainer(new Point(r.x, r.y));
			TreeNode t2 = getContainer(new Point(r.x + r.width, r.y));
			TreeNode t3 = getContainer(new Point(r.x, r.y + r.height));
			TreeNode t4 = getContainer(new Point(r.x + r.width, r.y + r.height));
			
			if( t1 == t2 && t1 == t3 && t1 == t4){
				return t1;
			}
			else{
				return null;
			}
			
		}
		
		
		//Adds a rectangle as long as it is fully contained inside another rectangle 
		public void addChild(Rectangle r) {
			TreeNode parentToBe = getFullyContainingRectangle(r);
			if(parentToBe == null){
				return;
			}
			else{
				parentToBe.children.add(new TreeNode(r, parentToBe));
			}
			
		}
		//Removes the smallest rectangle that contains this point.
		public void remove(Point p){
			TreeNode chop = getContainer(p);
			chop.parent.children.remove(chop);
		}
		
		
		
	
}
	
	
	