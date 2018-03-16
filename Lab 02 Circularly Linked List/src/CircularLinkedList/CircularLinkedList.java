package CircularLinkedList;


public class CircularLinkedList <E>{
	private int size;
	private Node<E> cursor;
	
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
		
		public void setPrev(Node<T> p){
			prev = p;
		}
		
		public void setNext(Node<T> n){
			next = n;
		}
	}
	
	public CircularLinkedList(){
		size = 0;
		cursor = null;
	}
	
	

	private void insertBetween(E v, Node<E> first, Node<E> second){
		Node<E> newNode = new Node<E>(v, second, first);
		first.next = newNode;
		second.prev = newNode;
		size++;
	}

	
	public void addAfterCursor(E v){
		if(size == 0){
			Node<E> newNode = new Node<E>(v, null, null);
			newNode.setNext(newNode);
			newNode.setPrev(newNode);
			cursor = newNode;
			size++;
			return;
		}
		insertBetween(v, cursor, cursor.next);
		return;
	}
	
	public E deleteCursor(){
		if(size == 0){
			System.out.println("List is empty");
			return null;
		}
		else if(size == 1){
			Node<E> temp = cursor;
			size--;
			return temp.value;
		}
		cursor = cursor.next;
		return removeBetween(cursor.prev.prev, cursor);
		
		
	}
	
	
	private E removeBetween(Node<E> first, Node<E> second){
		E value = first.next.value;
		first.next = second;
		second.prev = first;
		size--;
		return value;
	}
	

	
	public String toString(){
		if (size == 0){
			return "The list is empty";
		}
		String total = "" + cursor.value.toString() + " ";
		Node<E> temp = cursor.next;
		while (temp != cursor){
			total = total + temp.value + " ";
			temp = temp.next;
		}
		return total;
	}
	
	
	
	public int getSize(){
		return size;
	}
	
	public E getValue(){
		return cursor.value;
	}
	
	
	public void advanceCursor(int n){
		for(int i = 0; i < n; i++){
			cursor = cursor.next;
		}
	}
	
	
	
	
}
