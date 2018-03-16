import java.util.ArrayList;
import java.util.Iterator;

public class BST<E extends Comparable<E>> implements Set<E>
{	
	private Node<E> root;
	private int size;
	
	public BST()
	{
		root = null;
		size = 0;
	}
	
	
	private void populateSnapShotInOrder(Node<E> r, ArrayList<E> snapShot)
	{
		if(r == null)
		{
			return;
		}
		populateSnapShotInOrder(r.left, snapShot);
		snapShot.add(r.value);
		populateSnapShotInOrder(r.right, snapShot);
	}
	
	
	public Iterator<E> iterator() 
	{
		ArrayList<E> snapShot = new ArrayList<>();
		populateSnapShotInOrder(root, snapShot);
		return snapShot.iterator();
	}

	/**
	 * 
	 * @param v : value to search for
	 * @param r is the root of the subtree we are searching in
	 * @return three cases: null if tree is empty, if the value is contained then return the node, or returns the parent node where the value
	 * would have been a child
	 */
	private Node<E> findNode(E v, Node<E> r)
	{
		if(r == null)
		{
			return null;
		}
		
		if(r.value.compareTo(v) == 0)
		{
			return r;
		}
		
		if(r.right != null && r.value.compareTo(v) < 0)
		{
			return findNode(v, r.right);
		}
		
		if(r.left != null && r.value.compareTo(v) > 0)
		{
			return findNode(v, r.left);
		}
		
		//We are at a leaf and the value is not there
		//Return the parent where the node would have been
		return r;

	}
	
	public boolean add(E v) 
	{
		Node<E> n = findNode(v, root);
		if(n == null)
		{
			root = new Node<>(v);
			size++;
			return true;
		}
		
		if(n.value.equals(v))
		{
			return false;
		}
		
		if(n.value.compareTo(v) > 0)
		{
			n.left = new Node<>(v);
		}
		else
		{
			n.right = new Node<>(v);
		}
		size++;
		return true;
		
	}

	@Override
	public boolean remove(E v) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean contains(E v) 
	{
		Node<E> n = findNode(v, root);
		return n != null && n.value.equals(v);
	}

	public void addAll(Set<E> other)
	{
		Iterator<E> it = other.iterator();
		while(it.hasNext())
		{
			add(it.next());
		}
	}

	public void retainAll(Set<E> other) 
	{		
		Iterator<E> it = iterator();
		while(it.hasNext())
		{
			E temp = it.next();
			if(!other.contains(temp))
			{
				//CANNOT use the remove from Set because that would be unsafe
				//(removing from a set while iterating over its element)
				it.remove();
			}
		}
	}
	
	public String toString()
	{
		String r = "[";
		for(E i : this)
		{
			r += i +" ";
		}

		return r + "]";
	}

	public void removeAll(Set<E> other)
	{
		Iterator<E> it = other.iterator();
		while(it.hasNext())
		{
			E temp = it.next();
			if(contains(temp))
			{
				remove(temp);
			}
		}
	}
	private static class Node<T> implements Position<T>
	{
		private T value;
		private Node<T> left;
		private Node<T> right;
		
		public Node(T v)
		{
			value = v;
			left = null;
			right = null;
		}
		
		public T getValue()
		{
			return value;
		}
		
		public String toString()
		{
			return value.toString();
		}
	}

	

}
