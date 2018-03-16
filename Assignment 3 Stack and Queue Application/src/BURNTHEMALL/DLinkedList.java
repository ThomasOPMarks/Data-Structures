package BURNTHEMALL;

public class DLinkedList<E>
{
	private int size;
	private Node<E> header;
	private Node<E> trailer;
	
	public DLinkedList()
	{
		size = 0;
		
		header = new Node<E>(null, null, null);
		trailer = new Node<E>(null, null, header);
		header.next = trailer;
	}
	
	public void insertAtHead(E v)
	{
		insertBetween(v, header, header.next);
	}
	
	public void insertAtTail(E v)
	{
		insertBetween(v, trailer.prev, trailer);
	}
	
	private void insertBetween(E v, Node<E> first, Node<E> second)
	{
		Node<E> newNode = new Node<>(v, second, first);
		first.next = newNode;
		second.prev = newNode;
		size++;
	}
	
	public E removeAtHead()
	{
		return removeBetween(header, header.next.next);
	}
	
	public E removeAtTail()
	{
		return removeBetween(trailer.prev.prev, trailer);
	}
	private E removeBetween(Node<E> first, Node<E> second)
	{
		if(header.next == trailer)//if the list is empty
		{
			throw new IllegalStateException("The list is empty!");
		}
		E result = first.next.value;
		first.next = second;
		second.prev = first;
		size--;
		
		return result;
	}
	
	public E getFirst()
	{
		return header.next.value;
	}
	
	public E getLast()
	{
		return trailer.prev.value;
	}
	
	public String toStringBackward()
	{
		if(size == 0)
		{
			return "The list is empty!";
		}
		String r = "";
		Node<E> temp = trailer.prev;
		while(temp != header)
		{
			r += temp.toString() +" ";
			temp = temp.prev;
		}
		return r;
		

	}
	public String toString()
	{
		if(size == 0)
		{
			return "The list is empty!";
		}
		String r = "";
		Node<E> temp = header.next;
		while(temp != trailer)
		{
			r += temp +" ";
			temp = temp.next;
		}
		return r;
		
	}
	
	private static class Node<T>
	{
		private T value;
		private Node<T> next;
		private Node<T> prev;
		
		public Node(T v, Node<T> n, Node<T> p)
		{
			value = v;
			next = n;
			prev = p;
		}
		
		public String toString()
		{
			return value.toString();
		}
		
	}
	
	public int getSize(){
		return size;
	}
	

}
