package GroupPartition;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

public class UnionFind<T> implements GroupPartition<T>{
	//The union find, which is fast.
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
		if(nA == nB){
			return false;
		}
		else if(nA.rank > nB.rank){
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
			return true;
		}
		
		
	}
	
	private void print(){
		System.out.println(nodeTable.values());
	}
	@Override
	public T find(T data) {
		return findNode(nodeTable.get(data)).parent.value;
	}
	
	private Node<T> findNode(Node<T> n){
		if(n.parent == n){
			return n;
		}
		else{
			Node<T> returning = findNode(n.parent);
			n.parent = n.parent.parent;
			return returning;
		}
		
	}
	
	public String toString(){
		return nodeTable.toString();
	}
	
	public class Node<E> {
		public int rank;
		public E value;
		public Node<E> parent;
		public Node(E value){
			parent = this;
			this.value = value;
			rank = 0;
		}
		
		public String toString(){
			return "Node value: "+ value.toString()+", With Parent: " + this.parent.value;
		}
	}

}
