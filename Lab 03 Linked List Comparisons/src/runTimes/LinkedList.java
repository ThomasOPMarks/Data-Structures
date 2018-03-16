package runTimes;

public class LinkedList {
	private Node head;
	private Node tail;
	private int size;
	//Constructor
	public LinkedList(){
		size = 0;
		head = null;
	}
	//Puts the next node at the front of the list
	public void insertAtHead(int v){

		//make node
		Node newish = new Node(v, head);
		//head points to the new node
		head = newish;
		if( tail == null){
			tail = head;
		}
		//increase the size
		size++;
	}
	
	//Removes the head and returns the value of the head
	public int removeHead(){
		if(head == null){
			throw new IllegalStateException("List is empty, and cannot remove");
		}
		int removed = head.value;
		head = head.nextNode;
		size--;
		return removed;
	}
	//To string method that prints all values
	public String toString(){
		Node temp = head;
		String result = "";
		if(temp == null){
			return "List is empty";
		}
		while (temp != null){
			result += temp.toString() + " ";
			temp = temp.nextNode;
		}
		return result;
	}
	
	//The node class
	private class Node{
		private int value;
		private Node nextNode;
		
		public Node(int v, Node node){
			value = v;
			nextNode = node;
		}
		
		public String toString(){
			return "" + value;
		}
	}
	
	public int getSize(){
		return size;
	}

	//Puts a new node at the end of the list
	public void insertAtTail(int v){
		if(tail == null){
			tail = new Node(v, null);
			head = tail;
			size++;
			return;
		}
		Node newNode = new Node(v, null);
		tail.nextNode = newNode;
		size++;
		return;
	}

	//Find the min in the list
	public int min() throws Exception{
		if(head == null){
			throw new Exception("The list is empty");
		}
		int lowest = head.value;
		Node temp = head.nextNode;
		
		while (temp != null){
			if(temp.value < lowest){
				lowest = temp.value;
			}
			temp = temp.nextNode;
		}
		return lowest;
	}
	
	//Find the max by walking the list
	public int max() throws Exception{
		if(head == null){
			throw new Exception("The list is empty");
		}
		int highest = head.value;
		Node temp = head.nextNode;
		
		while (temp != null){
			if(temp.value > highest){
				highest = temp.value;
			}
			temp = temp.nextNode;
		}
		return highest;
	}

	//Removes the current tail and returns the value of the tail
	public int removeLast() throws Exception {
		if (size ==0){
			throw new Exception("List is empty");
		}
		if (head.nextNode == null){
			int returnValue = head.value;
			head = null;
			size--;
			return returnValue;
		}
		Node temp = head;
		while(temp.nextNode.nextNode != null){
			temp = temp.nextNode;
		}
		int returnValue = temp.nextNode.value;
		size--;
		temp.nextNode = null;
		return returnValue;
	}
	
	public void removeTail(){
		if (head == null){
			return;
		}
		if(head.nextNode == null){
			head = tail = null;
		}
		else{
			Node temp = head;
			
			while(temp.nextNode != tail){
				temp = temp.nextNode;
			}
			tail = temp;
			tail.nextNode = null;
		}
		size--;
	}
}
