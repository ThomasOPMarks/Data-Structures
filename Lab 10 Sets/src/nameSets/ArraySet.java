package nameSets;
import java.util.ArrayList;
import java.util.Iterator;

public class ArraySet<E> implements Set<E>
{
	private ArrayList<E> set;
	
	public ArraySet()
	{
		set = new ArrayList<>();
	}

	public Iterator<E> iterator() 
	{
		return set.iterator();
	}

	public boolean add(E v) 
	{
		if(this.contains(v))
		{
			return false;
		}
		set.add(v);
		return true;
	}

	public void remove(E v) 
	{
		set.remove(v);
		
	}

	public boolean contains(E v) 
	{
		return set.contains(v);
	}

	public void addAll(Set<E> other) 
	{
		Iterator<E> it = other.iterator();
		while(it.hasNext())
		{
			this.add(it.next());
		}
	}

	public void removeAll(Set<E> other) 
	{
		Iterator<E> it = other.iterator();
		while(it.hasNext())
		{
			remove(it.next());
		}
	}

	public void retainAll(Set<E> other) 
	{
		Iterator<E> it = this.iterator();
		while(it.hasNext())
		{
			if(other.contains(it.next()))
			{
				//CANNOT use the normal set.remove because
				//we are iterating over the list
				//Concurrent modification exception
				it.remove();
			}
		}
	}

}
