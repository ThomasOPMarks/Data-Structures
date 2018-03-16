package stackTurtle;

import java.awt.Point;
import java.util.Scanner;
import edu.princeton.cs.introcs.StdDraw;

public class Driver {
	public static void main(String[] args) {
		StdDraw.setCanvasSize(800, 800);
		StdDraw.setXscale(0, 800);
		StdDraw.setYscale(0, 800);
		StackTurtle st = new StackTurtle(new Point(400, 400));
		String command;
		Scanner keyboard = new Scanner(System.in);
		do {
			command = keyboard.next();
			//Only added the bracket add to the stack
			if (command.equalsIgnoreCase("f")) {
				st.moveForward(keyboard.nextDouble());
			} else if (command.equalsIgnoreCase("r")) {
				st.rotate(keyboard.nextDouble());
			}
			else if(command.equals("[")){
				st.pushCurrentPosition();
			}
			else if(command.equals("]")){
				st.popPosition();
			}
		} while (!command.equalsIgnoreCase("q"));
		System.exit(0);
	}
}