package SpatialTree;

import java.awt.Point;
import java.util.Comparator;

public class PointComparator implements Comparator<Point>{
	
	@Override
	public int compare(Point arg0, Point arg1) {
		// arg0 - arg1
		return arg0.x - arg1.x;
	}

}
