package SpatialTree;


import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.ArrayList;

//NOTE! 
//Worst case == (x,y) | x = y and the list is ordered
//Still bad case is when only the x's are ordered
//Normal case = random points
//Ideal = the tree is perfectly balanced
public class SpatialTree {
	private TreeNode root;
	public int visited;
	
	public SpatialTree(ArrayList<Point> p, Rectangle r){
		if(p.size() > 0){
			root = new TreeNode( p, true, r);
		}
		else{
			root = null;
		}
	}
	
	// Worst case: O(n^2) (n inserts at increasing values, 1 + 2+ 3... + n) 
	// Average case = Balanced tree = n * log(n), n inserts into a odd binary search tree. You could get this by ordering the list
	// and then after ordering it reorder it so you insert more "middle values" first into the array list you pass the constructor
	
	public class TreeNode implements Printable{
		//Instance variables
		private Point value;
		private boolean x;
		private Rectangle cutThis;
		private TreeNode small;
		private TreeNode big;
		private Line2D.Double theLine;
		public TreeNode(ArrayList<Point> p, boolean isX, Rectangle appriopriateSize){
			if(p.size() == 0){
				return;
			}
			x = isX;
			value = p.get(0);
			cutThis = appriopriateSize;
			theLine = constructLine();
			p.remove(0);
			ArrayList<Point> bigger = new ArrayList<>();
			ArrayList<Point> smaller = new ArrayList<>();
			//Sorts appropriately based off these conditions 
			if(!x){
				for(Point point : p){
					if(point.getY() > value.getY()){
						bigger.add(point);
					}
					else{
						smaller.add(point);
					}
				}
			}
			else{
				for(Point point : p){
					if(point.getX() > value.getX()){
						bigger.add(point);
					}
					else{
						smaller.add(point);
					}
				}
			}
			//Smaller Side construction
			if(smaller.size() > 0){
				if(x){
					small = new TreeNode(smaller, !this.x, new Rectangle(this.cutThis.x, this.cutThis.y, (value.x - this.cutThis.x), this.cutThis.height));
				}
				else{
					small = new TreeNode(smaller, !this.x, new Rectangle(this.cutThis.x, this.cutThis.y, this.cutThis.width, (value.y - this.cutThis.y)));
				}
			}
			else{
				small = null;
			}
			//Bigger Side construction 
			if(bigger.size() > 0){
				if(x){
					big = new TreeNode(bigger, !this.x, new Rectangle(value.x, this.cutThis.y, (this.cutThis.width - value.x + this.cutThis.x), this.cutThis.height));
				}
				else{
					big = new TreeNode(bigger, !this.x, new Rectangle(this.cutThis.x, value.y, this.cutThis.width, (this.cutThis.height - value.y + this.cutThis.y)));
				}
			}
			else{
				big = null;
			}
		}
		private Line2D.Double constructLine(){
			int x1;
			int x2;
			int y1;
			int y2;
			
			if(this.getType()){
				x1 = x2 = this.getPoint().x;
				y1 = this.getRectangle().y;
				y2 = this.getRectangle().y + this.getRectangle().height;
				return new Line2D.Double(x1, y1, x2, y2);
			}
			else{
				y1 = y2 = this.getPoint().y;
				x1 = this.getRectangle().x;
				x2 = this.getRectangle().x + this.getRectangle().width;
				return new Line2D.Double(x1, y1, x2, y2);
			}
		}
		@Override
		public Point getPoint() {
			return value;
		}
		@Override
		public Rectangle getRectangle() {
			return cutThis;
		}
		@Override
		public boolean getType() {
			return x;
		}
		@Override
		public Printable getSmaller() {
			return this.small;
		}
		@Override
		public Printable getBigger() {
			
			return this.big;
		}
		public String toString(){
			return value.toString() + cutThis.toString();
		}
		@Override
		public Line2D.Double getLine() {
			
			return theLine;
		}
	}
	//To String method
	//O(n), because it just visits one node each time and uses a string builder to make the string
	public String toString(){
		StringBuilder total = new StringBuilder();
		stringHelper(root, 0, total);
		return total.toString();
	}
	
	//Recursively builds a string for the tree, and was covered above. This recusively when called on the root is O(n)
	private StringBuilder stringHelper(TreeNode r, int depth, StringBuilder total){
		if(r == null){
			return total;
		}
		for(int i = 0; i < depth; i++){
			total.append("  ");
		}
		total.append("(" + depth+ ") " + "Point (" + r.value.x + ", " + r.value.y + ") Rectangle (" + r.cutThis.x + ", " + r.cutThis.y + ", " + r.cutThis.width + ", " + r.cutThis.height + ")\n");
		stringHelper(r.small, depth + 1, total);
		stringHelper(r.big, depth + 1, total);
		
		
		return total;
	}
	//This is weird. Worst case is O(n), because you must visit every nod. 
	//A typical case may will be like if you visit maybe 1/4 of the list, or O(n), so the same. We do reduce the nodes we visit though
	public ArrayList<Printable> query(Point mouseStart, double radius, ArrayList<Printable> list, Printable n){
		visited = 0;
		return snapshotForPoints(mouseStart, radius, list, n);
	}
	
	public Printable getRoot() {
		return this.root;
	}
	
	//This method makes a snapshot of all the printables that have Points to color in, signifying that they are close;
	//This is O(n), with the same typical case as the above method
	public ArrayList<Printable> snapshotForPoints(Point mouseStart, double radius, ArrayList<Printable> list, Printable n){
			visited++;
			if(Math.sqrt((n.getPoint().getX() - mouseStart.getX()) * (n.getPoint().getX() - mouseStart.getX()) + (n.getPoint().getY() - mouseStart.getY()) * (n.getPoint().getY() - mouseStart.getY())) < radius){
				list.add(n);
			}
			
			Line2D.Double line = n.getLine();
			if(line.ptSegDist(mouseStart.getX(), mouseStart.getY()) < radius){
				if(n.getSmaller() != null){
					snapshotForPoints(mouseStart, radius, list, n.getSmaller());
				}
				if(n.getBigger() != null){
					snapshotForPoints(mouseStart, radius,list, n.getBigger());
				}
			}
			else{
				if(n.getType()){
					if(n.getPoint().getX() > mouseStart.getX()){
						if(n.getSmaller() != null){
							snapshotForPoints(mouseStart, radius,list, n.getSmaller());
						}
					}
					else{
						if(n.getBigger() != null){
							snapshotForPoints(mouseStart, radius,list, n.getBigger());
						}
					}
				}
				else{
					if(n.getPoint().getY() > mouseStart.getY()){
						if(n.getSmaller() != null){
							snapshotForPoints(mouseStart, radius,list, n.getSmaller());
						}
					}
					else{
						if(n.getBigger() != null){
							snapshotForPoints(mouseStart, radius,list, n.getBigger());
						}
					}
				}
			}
			
			return list;
		}
	
	
}
