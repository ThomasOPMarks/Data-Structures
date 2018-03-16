package runTimes;


public class DLinkedList <E>{
	private int size;
	private Node<E> header;
	private Node<E> trailer;
	
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
	
	public DLinkedList(){
		size = 0;
		header = new Node<E>(null, null, null);
		trailer = new Node<E>(null, null, header);
		header.next = trailer;
	}
	

	private void insertBetween(E v, Node<E> first, Node<E> second){
		Node<E> newNode = new Node<E>(v, second, first);
		first.next = newNode;
		second.prev = newNode;
		size++;
	}

	
	public void insetAtHead(E v){
		insertBetween(v, header, header.next);
	}
	
	public void insetAtTail(E v){
		insertBetween(v, trailer.prev, trailer);
	}
	
	
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
	
	public E removeAtHead(){
		return (E) removeBetween(header, header.next.next);
	}
	
	public E removeAtTail(){
		return (E) removeBetween(trailer.prev.prev, trailer);
	}
	
	public String toString(){
		if (header.next == trailer){
			return "The list is empty";
		}
		StringBuilder total = new StringBuilder();
		Node<E> temp = header.next;
		while (temp != trailer){
			total = total.append(temp.value.toString());
			temp = temp.next;
		}
		return total.toString();
	}
	
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
	
	
	
	
	
	
	
	
	
	
}
