package BURNTHEMALL;

import java.util.Random;
//The forest class, with an array that represents the forest
public class Forest {
	private int[][] forest;
	private int height;
	private int width;
	
	//The constructor that makes a forest with the appropriate sizes
	public Forest(int width, int height, double real){
		forest = new int[width][height];
		this.width = width;
		this.height = height;
		assert real <= 0 || 1 >= real;
		Random r = new Random();
		
		for(int i = 0; i < width; i++){
			for (int j = 0; j < height; j++){
				if(real >= r.nextDouble()){
					forest[i][j] = 1;
				}
				else{
					forest[i][j] = 0;
				}
			}
		}
		
	}
	//Prints out the array
	public String toString(){
		StringBuilder total = new StringBuilder();
		
		for(int i = 0; i < width; i++){
			for (int j = 0; j < height; j++){
				total.append("" + forest[i][j] +" ");
			}
			total.append("\n");
		}
		
		
		return total.toString();
	}
	//Getters 
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	//Does a depth first search, which uses a stack (inserts at tail, removes at tail).
	public boolean DepthFirstSearch(){
	
		DLinkedList<indexPair> cellsToExplore = new DLinkedList<>();
		
		for(int i = 0; i < width; i++){
			if(forest[0][i] == 1){
				cellsToExplore.insertAtTail(new indexPair(0,i));
			}
		}
		
		while(cellsToExplore.getSize() != 0){
			indexPair current = cellsToExplore.removeAtTail();
			forest[current.i][current.j] = 2;
			if(current.i == height - 1){
				return true;
			}
			try{
				if(forest[current.i + 1][current.j] == 1){
					cellsToExplore.insertAtTail(new indexPair(current.i + 1, current.j));
				}
			}
			catch (ArrayIndexOutOfBoundsException e){
			}
			try{
				if(forest[current.i][current.j +1] == 1){
					cellsToExplore.insertAtTail(new indexPair(current.i, current.j-1));
				}
			}
			catch (ArrayIndexOutOfBoundsException e){
			}
			try{
				if(forest[current.i][current.j -1] == 1){
					cellsToExplore.insertAtTail(new indexPair(current.i, current.j+1));
				}
			}
			catch (ArrayIndexOutOfBoundsException e){
			}
			
			try{
				if(forest[current.i - 1][current.j] == 1){
					cellsToExplore.insertAtTail(new indexPair(current.i - 1, current.j));
				}
			}
			catch (ArrayIndexOutOfBoundsException e){
			}
		}
		return false;
		
	}
	//Does a breadth first search, which uses a queue (first in first out)
	public boolean BreadthFirstSearch(){
		DLinkedList<indexPair> cellsToExplore = new DLinkedList<>();
		
		for(int i = 0; i < width; i++){
			if(forest[0][i] == 1){
				cellsToExplore.insertAtTail(new indexPair(0,i));
			}
		}
		
		while(cellsToExplore.getSize() != 0){
			indexPair current = cellsToExplore.removeAtHead();
			forest[current.i][current.j] = 2;
			if(current.i == height - 1){
				return true;
			}
			try{
				if(forest[current.i][current.j -1] == 1){
					cellsToExplore.insertAtTail(new indexPair(current.i, current.j-1));
				}
			}
			catch (ArrayIndexOutOfBoundsException e){
			}
			try{
				if(forest[current.i][current.j +1] == 1){
					cellsToExplore.insertAtTail(new indexPair(current.i, current.j+1));
				}
			}
			catch (ArrayIndexOutOfBoundsException e){
			}
			try{
				if(forest[current.i + 1][current.j] == 1){
					cellsToExplore.insertAtTail(new indexPair(current.i + 1, current.j));
				}
			}
			catch (ArrayIndexOutOfBoundsException e){
			}
			try{
				if(forest[current.i - 1][current.j] == 1){
					cellsToExplore.insertAtTail(new indexPair(current.i - 1, current.j));
				}
			}
			catch (ArrayIndexOutOfBoundsException e){
			}
		}
		
		return false;
	}
	//This is a private class that stores the pair of indexes, of cells to be searched.
	private class indexPair{
		protected int i;
		protected int j;
		
		public indexPair(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
}
