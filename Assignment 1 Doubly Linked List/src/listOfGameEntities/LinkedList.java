package listOfGameEntities;
//A Generic Linked List 
public class LinkedList <E>{
	private Node<E> head;
	private int size;
	//Constructor
	public LinkedList(){
		size = 0;
		head = null;
	}
	//Puts the next node at the front of the list
	public void insertAtHead(E v){

		//make node
		Node<E> newish = new Node<E>(v, head);
		//head points to the new node
		head = newish;
		//increase the size
		size++;
	}
	
	//Removes the head and returns the value of the head
	public E removeHead(){
		if(head == null){
			throw new IllegalStateException("List is empty, and cannot remove");
		}
		E removed = head.value;
		head = head.nextNode;
		size--;
		return removed;
	}
	//To string method that prints all values
	public String toString(){
		Node<E> temp = head;
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
	private class Node <T>{
		private T value;
		private Node<T> nextNode;
		
		public Node(T v, Node<T> n){
			value = v;
			nextNode = n;
		}
		
		public String toString(){
			return value.toString();
		}
		
	}
	
	public int getSize(){
		return size;
	}

	//Puts a new node at the end of the list
	public void insertAtTail(E v){
		if(head == null){
			head = new Node<E>(v, null);
			size++;
			return;
		}
		Node<E> temp = head;
		//advanced until end
		while(temp.nextNode != null){
			temp = temp.nextNode;
		}
		
		Node<E> newNode = new Node<E>(v, null);
		temp.nextNode = newNode;
		size++;
	}

	
	
	

	//Removes the current tail and returns the value of the tail
	public E removeLast() throws Exception {
		if (size ==0){
			throw new Exception("List is empty");
		}
		if (head.nextNode == null){
			E returnValue = head.value;
			head = null;
			size--;
			return returnValue;
		}
		Node<E> temp = head;
		while(temp.nextNode.nextNode != null){
			temp = temp.nextNode;
		}
		E returnValue = temp.nextNode.value;
		size--;
		temp.nextNode = null;
		return returnValue;
	}

	public boolean remove(E t){
		if(head == null){
			return false;
		}
		if (((GameCharacter)t).equals((GameCharacter)head.value)){
			head = head.nextNode;
			size--;
			return true;
		}
		Node<E>previous = head;
		Node<E>temp = head.nextNode;
		
		while(temp != null){
			if ((t).equals(temp.value)){
				previous.nextNode = temp.nextNode;
				size--;
				return true;
			}
			previous = previous.nextNode;
			temp = temp.nextNode;
		}
		return false;
	}
}
