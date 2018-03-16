package listOfGameEntities;
// A generic Doubly Linked list 
public class DLinkedList <E>{
	//The three data members of the doubly linked list, the size and two sentential nodes. 
	private int size;
	private Node<E> header;
	private Node<E> trailer;
	//The node class
	private static class Node <T>{
		private T value;
		private Node<T> next;
		private Node<T> prev;
		
		public Node(T v, Node<T> n, Node<T> p){
			value = v;
			next = n;
			prev = p;
		}
		
		public String toString(){
			return value.toString();
		}
	}
	//The constructor
	public DLinkedList(){
		size = 0;
		header = new Node<E>(null, null, null);
		trailer = new Node<E>(null, null, header);
		header.next = trailer;
	}
	
	//A method that inserts a new value between any two nodes
	private void insertBetween(E v, Node<E> first, Node<E> second){
		Node<E> newNode = new Node<E>(v, second, first);
		first.next = newNode;
		second.prev = newNode;
		size++;
	}

	//A method that inserts a value at the head
	public void insertAtHead(E v){
		insertBetween(v, header, header.next);
	}
	//A method that inserts a value at the tail
	public void insetAtTail(E v){
		insertBetween(v, trailer.prev, trailer);
	}
	
	// A method that removes nodes between two given nodes (only used to remove one node here)
	private E removeBetween(Node<E> first, Node<E> second){
		if (header.next == trailer){
			return null;
		}
		E value = (E) first.next.value;
		first.next = second;
		second.prev = first;
		size--;
		return value;
	}
	//Remove the first actual node
	public E removeAtHead(){
		return (E) removeBetween(header, header.next.next);
	}
	//Remove the last actual node
	public E removeAtTail(){
		return (E) removeBetween(trailer.prev.prev, trailer);
	}
	//Print the whole list
	public String toString(){
		if (header.next == trailer){
			return "The list is empty";
		}
		String total = "";
		Node<E> temp = header.next;
		while (temp != trailer){
			total = total + temp.value + " ";
			temp = temp.next;
		}
		return total;
	}
	//Prints the lsit backward
	public String printBackward(){
		if (header.next == trailer){
			return "The list is empty";
		}
		String total = "";
		Node<E> temp = trailer.prev;
		while (temp != header){
			total = total + temp.value + " ";
			temp = temp.prev;
		}
		return total;
	}
	//Remove the object that is passed to the method if it is in the list
	//If it was removed it returns true, else it returns false 
	public boolean remove(E remove){
		Node<E> temp = header.next;
		
		while(temp != trailer){
			if(temp.value.equals(remove)){
				removeBetween(temp.prev, temp.next);
				size--;
				return true;
			}
			temp = temp.next;
		}
		
		return false; 
	}
	
	
	
	
	
	
	
	
}
