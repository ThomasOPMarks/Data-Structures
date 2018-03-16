package ArrayGrowth;

public class ExpandableArrayList<E> implements List<E>
{
	protected E[] theArray;
	protected int size;

	public ExpandableArrayList()
	{
		theArray = (E[]) new Object[16];
		size = 0;
	}
	
	protected void expandArray()
	{
		E[] tempArray = (E[]) new Object[theArray.length * 2];
		
		for(int i=0; i < size; i++)
		{
			tempArray[i] = theArray[i];
		}
		
		theArray = tempArray;
	}
	
	public void add(E v) 
	{
		if(size == theArray.length)
		{
			expandArray();
		}
		
		theArray[size] = v;
		size++;
	}

	public void add(E v, int index) 
	{
		if(index <0 || index > size)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		
		if(size == theArray.length)
		{
			expandArray();
		}
		
		//shift the values from index to size
		for(int i=size-1; i >= index; i--)
		{
			theArray[i+1] = theArray[i];
		}
		
		
		theArray[index] = v;
		size++;
	}

	private void validateIndex(int index)
	{
		if(index < 0 || index >= size)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	public E remove(int index) 
	{
		validateIndex(index);
		E value = theArray[index];
		
		for(int i=index; i < size-1; i++)
		{
			theArray[i] = theArray[i+1];
		}
		
		theArray[size-1] = null;
		size--;
				
		return value;
	}
	

	public E get(int index) 
	{
		validateIndex(index);
		return theArray[index];
	}

	public E set(E v, int index) 
	{
		validateIndex(index);
		E value = theArray[index];
		theArray[index] = v;
		return value;
	}

	public int size()
	{
		return size;
	}
	
	public String toString()
	{
		StringBuilder sb  = new StringBuilder("[");
		for(int i=0; i < size; i++)
		{
			sb.append(theArray[i] + " ");
		}
		
		return sb.toString() + "]";
	}
	
	public int capacity()
	{
		return theArray.length;
	}

}
