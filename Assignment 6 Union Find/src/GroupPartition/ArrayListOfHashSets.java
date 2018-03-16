package GroupPartition;

import java.util.ArrayList;
import java.util.HashSet;

public class ArrayListOfHashSets<T> implements GroupPartition<T>{
	ArrayList<Nodes<T>> list;
	//The one that I came up with, which is an array list of hash tables.
	public ArrayListOfHashSets(){
		list = new ArrayList<>();
	}
	
	private class Nodes<T>{
		HashSet<T> values;
		T rep;
		
		Nodes(T value){
			rep = value;
			values = new HashSet();
		}
	}

	@Override
	public void makeSet(T data) {
		list.add(new Nodes(data));
		
	}

	@Override
	public boolean combineGroup(T a, T b) {
		T aRep = find(a);
		T bRep = find(b);
		
		if(aRep == bRep){
			return false;
		}
		int aIndex = -1;
		int bIndex = -1;
		for(int i = 0; i < list.size(); i++){
			if(aRep.equals(list.get(i).rep)){
				aIndex = i;
			}
		}
		
		for(int i = 0; i < list.size(); i++){
			if(bRep.equals(list.get(i).rep)){
				bIndex = i;
				return false;
			}
		}
		
		if(list.get(aIndex).values.size() > list.get(bIndex).values.size()){
			list.get(aIndex).values.addAll(list.get(bIndex).values);
			list.get(aIndex).values.add(list.get(bIndex).rep);
			list.remove(bIndex);
		}
		
		else if(list.get(aIndex).values.size() < list.get(bIndex).values.size()){
			list.get(bIndex).values.addAll(list.get(aIndex).values);
			list.get(bIndex).values.add(list.get(aIndex).rep);
			list.remove(aIndex);
		}
		
		else {
			list.get(aIndex).values.addAll(list.get(bIndex).values);
			list.get(aIndex).values.add(list.get(bIndex).rep);
			list.remove(bIndex);
		}
		return true;
	}

	@Override
	public T find(T data) {
		for(int i = 0; i < list.size(); i++){
			if(data.equals(list.get(i).rep) || list.get(i).values.contains(data)){
				return list.get(i).rep;
			}
		}
		return null;
	}

}
