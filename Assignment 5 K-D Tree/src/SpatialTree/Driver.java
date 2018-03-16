package SpatialTree;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class Driver {
	public static void main(String args[]){
		ArrayList<Point> points = new ArrayList<>();
		ArrayList<Point> sortedPoints = new ArrayList<>();
		
		/*points.add(new Point(40,40));
		points.add(new Point(20,20));
		points.add(new Point(80,80));
		points.add(new Point(10,10));
		points.add(new Point(90,90));*/
		Random r = new Random();
		for(int i =0; i < 1000; i++){
			points.add(new Point(r.nextInt(1000), r.nextInt(1000)));
			sortedPoints.add(new Point(i, i));
		}
		MainWindow random = new MainWindow(points, 1000,1000, "Random");
		points.sort(new PointComparator());
		MainWindow sorted = new MainWindow(points, 1000,1000, "Sorted");
		MainWindow order = new MainWindow(sortedPoints, 1000,1000, "Ordered");
		
	}
	
}
