package listOfGameEntities;

public class Driver {
	public static void main(String args[]){
		//Make 5 characters, that aren't inappropriate or based off real life people
		GameCharacter lane = new GameCharacter("Lane SX Smith");
		GameCharacter ken = new GameCharacter("Ken PD Tak");
		GameCharacter tom = new GameCharacter("Thom BJ Marks");
		GameCharacter james = new GameCharacter("James SL Boyceyonce");
		GameCharacter drew = new GameCharacter("Drew TL Harrilchak");
		
		//Make the single linked list, that uses the GameCharacter class for the generic,
		//and insert all the characters 
		LinkedList<GameCharacter> list = new LinkedList<>();
		list.insertAtHead(lane);
		list.insertAtHead(ken);
		list.insertAtHead(drew);
		list.insertAtHead(tom);
		list.insertAtHead(james);
		
		//Print the list out 
		System.out.println(list);
		//Remove the first, print out the truth value, and print the list
		System.out.println(list.remove(james)+ "\n");
		System.out.println(list);
		//Remove the last, print out the truth value, and print the list
		System.out.println(list.remove(lane)+ "\n");
		System.out.println(list);
		//Remove one not in the list, print out the truth value, and print the list
		System.out.println(list.remove(lane)+ "\n");
		System.out.println(list);
		
		//Remove the middle, print out the truth value, and print the list
		System.out.println(list.remove(drew)+ "\n");
		System.out.println(list);
		//Remove to empty, print out the truth value, and print the list
		System.out.println(list.remove(ken)+ "\n");
		System.out.println(list);
		//Remove to empty, print out the truth value, and print the list
		System.out.println(list.remove(tom)+ "\n");
		System.out.println(list);
		//Remove from an empty, print out the truth value, and print the list
		System.out.println(list.remove(tom)+ "\n");
		System.out.println(list);
		
		
		//Make the single linked list, that uses the GameCharacter class for the generic,
		//and insert all the characters 
		DLinkedList<GameCharacter> list2 = new DLinkedList<>();
		list2.insertAtHead(lane);
		list2.insertAtHead(ken);
		list2.insertAtHead(drew);
		list2.insertAtHead(tom);
		list2.insertAtHead(james);
		
		//Print the list out 
		System.out.println(list2);
		//Remove the first, print out the truth value, and print the list
		System.out.println(list2.remove(james)+ "\n");
		System.out.println(list2);
		//Remove the last, print out the truth value, and print the list
		System.out.println(list2.remove(lane)+ "\n");
		System.out.println(list2);
		//Remove one not in the list, print out the truth value, and print the list
		System.out.println(list2.remove(lane)+ "\n");
		System.out.println(list2);
		
		//Remove the middle, print out the truth value, and print the list
		System.out.println(list2.remove(drew)+ "\n");
		System.out.println(list2);
		//Remove to empty, print out the truth value, and print the list
		System.out.println(list2.remove(ken)+ "\n");
		System.out.println(list2);
		//Remove to empty, print out the truth value, and print the list
		System.out.println(list2.remove(tom)+ "\n");
		System.out.println(list2);
		//Remove from an empty, print out the truth value, and print the list
		System.out.println(list2.remove(tom)+ "\n");
		System.out.println(list2);
	}
}
