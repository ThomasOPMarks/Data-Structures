import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class DSTDriver {
	public static void main(String[] args) throws FileNotFoundException
	{
		//First integers
		int n = 1000;
		Random r = new Random();
		BST<Integer> intTreeOrder = new BST<>();
		BST<Integer> intTreeRandom = new BST<>();
		
		
		long orderStart = System.currentTimeMillis();
		for(int i = 0; i < n; i++){
			intTreeOrder.add(i);
		}
		long orderEnd = System.currentTimeMillis();
		
		long randomStart = System.currentTimeMillis();
		for(int i = 0; i < n; i++){
			intTreeRandom.add(r.nextInt(n));
		}
		long randomEnd = System.currentTimeMillis();
		
		System.out.println("In order: " + (orderEnd - orderStart));
		System.out.println("In random: " + (randomEnd - randomStart));
		/*The first tree isn't very much of a tree, because it is in fact the worse case scenario, when all the values in the tree are inserted
		 * in a way that makes the tree look like a linked list, so every add is of the order O(n)
		 * 
		 * The second tree has different values put into the tree randomly, and while potentially won't have an O(n) time (very small chance it could)
		 * It can probably more quickly find the spot near a log(n) time.
		 * 
		 * 
		 */
		
		
		//Next Books and the dictionary
		Scanner words = new Scanner(new FileInputStream("Words.txt"));
		Scanner war = new Scanner(new FileInputStream("warAndPeace.txt"));
		
		
		BST<String> treeOrder = new BST<>();
		BST<String> treeRandom = new BST<>();
		orderStart = System.currentTimeMillis();
		while(words.hasNext()){
			treeOrder.add(words.next());
			
		}
		orderEnd = System.currentTimeMillis();
		
		randomStart = System.currentTimeMillis();
		while(war.hasNext()){
			treeRandom.add(war.next());
			
		}
		randomEnd = System.currentTimeMillis();
		
		words.close();
		war.close();
		
		System.out.println("In order words time to make in Miliseconds: " + (orderEnd - orderStart));
		System.out.println("In random (the book) time to make in Miliseconds: " + (randomEnd - randomStart));
		
		
	}

}
