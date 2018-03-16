package lists;

import java.util.Random;


public class Driver {
	public static void main(String args[]){
		//make list with ten values
		LinkedList list = new LinkedList();
		System.out.println(list);
		Random r = new Random();
		r.setSeed(100);
		System.out.println("Now a list with 10 elements");
		for (int i = 0; i < 10; i++){
			list.insertAtHead(r.nextInt(20));
		}
		//print the list
		System.out.println("List: " + list);
		
		//Find the min and max, and catch the empty exception
		try {
			System.out.println("Max value: "+list.min());
			System.out.println("Min value: "+ list.max());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		//Find the 
		for (int i = 0; i < 4; i++){
			try {
				System.out.println("Last removed value: " + list.removeLast());
			} catch (Exception e) {
				System.out.println(e.getMessage());
				//e.printStackTrace();
			}
		}
		
		System.out.println("List: " + list);
		//Showing the list with small number of elemnts and how it deals
		System.out.println("Now a list with 3 elements");
		list = new LinkedList();
		for (int i = 0; i < 3; i++){
			list.insertAtHead(r.nextInt(20));
		}
		
		System.out.println("List: " + list);
		
		for (int i = 0; i < 4; i++){
			try {
				System.out.println("Last removed value: " + list.removeLast());
			} catch (Exception e) {
				System.out.println(e.getMessage());
				//e.printStackTrace();
			}
		}
	}
	
}
