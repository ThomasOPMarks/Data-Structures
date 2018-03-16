package GroupPartition;

public interface GroupPartition<T> {
	//The interface that will be used
	public void makeSet(T data);
	public boolean combineGroup(T a, T b);
	public T find(T data);

}
