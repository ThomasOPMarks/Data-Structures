package GroupPartition;

import java.util.Hashtable;

public class UnionFind<T> implements GroupPartition<T>{
	private Hashtable<T, Node<T>> nodeTable;
	
	public UnionFind(){
		nodeTable =  new Hashtable<>();
	}
	@Override
	public void makeSet(T data) {
		nodeTable.put(data, new Node<>(data));
	}

	@Override
	public boolean combineGroup(T a, T b) {
		Node<T> nA = findNode(nodeTable.get(a));
		Node<T> nB = findNode(nodeTable.get(b));
		if(nA.rank > nB.rank){
			nB.parent = nA;
			return true;
		}
		else if(nB.rank > nA.rank){
			nA.parent = nB;
			return true;
		}
		else{
			nB.parent = nA;
			nA.rank = nA.rank + 1;
			return false;
		}
	}

	@Override
	public T find(T data) {
		return findNode(nodeTable.get(data)).parent.value;
	}
	
	private Node<T> findNode(Node<T> n){
		if(n.parent == n){
			return n;
		}
		n.parent = n.parent.parent;
		return n.parent;
	}
	
	public String toString(){
		return nodeTable.toString();
	}


}
