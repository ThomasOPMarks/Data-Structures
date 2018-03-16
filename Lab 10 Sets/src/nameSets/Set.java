package nameSets;

public interface Set<E> extends Iterable<E>
{
	public boolean add(E v);
	public void remove(E v);
	public boolean contains(E v);
	public void addAll(Set<E> other);
	public void removeAll(Set<E> other);
	public void retainAll(Set<E> other);
	


}
