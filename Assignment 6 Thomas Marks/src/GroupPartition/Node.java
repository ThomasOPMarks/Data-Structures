package GroupPartition;

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
		return "Node value: "+ value.toString();
	}
}

//Factors wth min branching factor
//min branching is the t
//max number of children is 2t
//max number of keys is 2t - 1