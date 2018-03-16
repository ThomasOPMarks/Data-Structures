package stackTurtle;

import java.awt.Point;
import java.util.ArrayList;

import edu.princeton.cs.introcs.StdDraw;

public class StackTurtle { 
	private ArrayList<StackTurtle> stack = new ArrayList<>();
	private Point currentPosition;
	private double angle;

	public StackTurtle(Point startingPosition) {
		currentPosition = startingPosition;
		angle = 90;
	}
	public StackTurtle(StackTurtle t){
		currentPosition = new Point(t.currentPosition);
		angle = t.angle;
		stack = t.stack;
	}

	public void moveForward(double distance) {
		Point newPosition = new Point((int) (currentPosition.x + distance * Math.cos(Math.toRadians(angle))),
				(int) (currentPosition.y + distance * Math.sin(Math.toRadians(angle))));
		StdDraw.line(currentPosition.x, currentPosition.y, newPosition.x, newPosition.y);
		currentPosition = newPosition;
	}

	public void rotate(double degrees) {
		angle += degrees;
	}
	//Pushes a turtle to the array stack
	public void pushCurrentPosition(){
		stack.add(0, new StackTurtle(this));
	}
	//Removes a turtle from the stack, implemented in an array.
	public void popPosition(){
		StackTurtle temp = stack.get(0);
		//this.angle = temp.angle;
		this.currentPosition = temp.currentPosition;
		stack.remove(0);
		return;
		
	}
}