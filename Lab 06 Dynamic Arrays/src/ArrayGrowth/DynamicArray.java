package ArrayGrowth;

public class DynamicArray<T> extends ExpandableArrayList<T>{
	public DynamicArray(){
		super();
	}
	
	@Override
	protected void expandArray(){
		T[] tempArray = (T[]) new Object[theArray.length + 10000];
		
		for(int i=0; i < size; i++)
		{
			tempArray[i] = theArray[i];
		}
		
		theArray = tempArray;
	}
	
	
	
}
