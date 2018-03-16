import java.util.Iterator;

public interface Set<E> extends Iterable<E>
{
	public boolean add(E v);
	public boolean remove(E v);
	public boolean contains(E v);
	
	
	public void addAll(Set<E> other);
	public void retainAll(Set<E> other);
	public void removeAll(Set<E> other);
	

}
