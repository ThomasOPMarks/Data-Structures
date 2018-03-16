package SpatialTree;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

public interface Printable {
	Point getPoint();
	Rectangle getRectangle();
	boolean getType();
	Printable getSmaller();
	Printable getBigger();
	Line2D.Double getLine();
	

}
