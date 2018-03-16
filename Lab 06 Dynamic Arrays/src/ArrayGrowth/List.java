package ArrayGrowth;

public interface List<E>
{
	public void add(E v);
	public void add(E v, int index);
	public E remove(int index);
	public E get(int index);
	public E set(E v, int index);
	public int size();
}
