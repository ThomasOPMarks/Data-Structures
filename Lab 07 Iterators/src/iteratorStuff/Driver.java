package iteratorStuff;

import java.util.Iterator;

public class Driver {
	public static void main(String args[]){
		DoublyLinkedList<Integer> shortList = new DoublyLinkedList<>();
		DoublyLinkedList<Integer> longList = new DoublyLinkedList<>();
		
		for (int i = 0; i < 2; i++){
			shortList.addFirst(i);
		}
		
		for (int i = 0; i < 20; i++){
			longList.addFirst(i);
		}
		
		Iterator<Integer> oneWay = shortList.iterator();
		TwoWayIterator<Integer> bothWays = longList.twoWayIterator();
		
		while(oneWay.hasNext()){
			System.out.print(oneWay.next() + " ");
		}
		System.out.println("");
		while(bothWays.hasNext()){
			System.out.print(bothWays.next() + " ");
		}
		System.out.println("");
		while(bothWays.hasPrevious()){
			System.out.print(bothWays.previous() + " ");
		}
	}
}
