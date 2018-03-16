import java.util.ArrayList;
import java.util.Arrays;

public class Driver {
	
	private static int n = 50;
	public static void main(String args[]){
		int rCol = 0;
		int sCol = 0;
		int mrCol = 0;
		int msCol = 0;
		ArrayList<Integer> random = new ArrayList<>();
		ArrayList<Integer> ordered = new ArrayList<>();
		ArrayList<ArrayList<Integer>> boxes = newBoxes();
		
		random.addAll(Arrays.asList(41, 28, 11, 80, 40, 75, 21, 0, 90, 44, 95, 70, 83, 98, 1, 43, 4, 85, 79, 87));
		ordered.addAll(Arrays.asList( 0, 50, 100, 150, 200, 250, 300, 350, 400, 450, 500, 550, 600, 650, 700, 750, 800, 850, 900, 950));
		int index = 0;
		for(int i = 0; i < random.size() -1; i++){
			index = modHash(random.get(i));
			if(boxes.get(index).size() > 0){
				rCol++;
			}
			boxes.get(index).add(random.get(i));
		}
		
		System.out.println("First list MOD hash collisions: " + rCol);
		
		
		boxes = newBoxes();
		for(int i = 0; i < ordered.size() -1; i++){
			index = modHash(ordered.get(i));
			if(boxes.get(index).size() > 0){
				sCol++;
			}
			boxes.get(index).add(ordered.get(i));
		}
		
		System.out.println("Second list MOD hash collisions: " + sCol);
		
		boxes = newBoxes();
		
		System.out.println("With random values the modulus is ok, but can easily be ruined by applying selected values to fill the same bin. This can make a running time of O(n).");
		for(int i = 0; i < random.size() -1; i++){
			index = MADHash(random.get(i));
			if(boxes.get(index).size() > 0){
				mrCol++;
			}
			boxes.get(index).add(random.get(i));
		}
		
		System.out.println("First list MAD hash collisions: " + mrCol);
		
		
		boxes = newBoxes();
		for(int i = 0; i < ordered.size() -1; i++){
			index = MADHash(ordered.get(i));
			if(boxes.get(index).size() > 0){
				msCol++;
			}
			boxes.get(index).add(ordered.get(i));
		}
		
		System.out.println("Second list MAD hash collisions: " + msCol);
	}
	
	public static int modHash(int v){
		return v%n;
	}
	
	public static int MADHash(int v){
		return ((2*v + 11)%31%n);
	}
	
	public static ArrayList<ArrayList<Integer>> newBoxes(){
		ArrayList<ArrayList<Integer>> boxes = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < n; i++){
			boxes.add(new ArrayList<Integer>());
		}
		return boxes;
	}
}
