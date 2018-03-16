package CircularLinkedList;

import java.util.Random;

public class Driver {
	public static void main(String args[]){
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		for(int i = 0; i < 10; i++){
			list.addAfterCursor(i+1);
		}
		
		System.out.println(list);
		
		Random r = new Random();
		while(list.getSize() != 0){
			list.advanceCursor(r.nextInt(list.getSize()));
			System.out.print(list.deleteCursor() + " ");
		}
	}
}
