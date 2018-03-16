package GroupPartition;

public interface GroupPartition<T> {
	public void makeSet(T data);
	public boolean combineGroup(T a, T b);
	public T find(T data);

}
