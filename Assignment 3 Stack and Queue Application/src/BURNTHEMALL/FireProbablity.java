package BURNTHEMALL;

public class FireProbablity {// The classes that deals with calculating the burning probability
	public static int turns = 10000;
	public static double percentageOfBurn( double p, int mode){//Pass this a zero to do depth first, anything else to do breadth first. Burns turns amount, in this case 10000

																// Big O analysis: Both of these worst cases are when
																// The forest burns completely except on the bottom row,
																//i.e. Every forest cell except in the last row is a one, and the 
																//bottom row is all zeros.
																//In this case both burning algorithms are O(n), because they must burn
																//a linear amount of tiles every time, and both will burn all cells
																//Note: depth search is just quicker though
		int count = 0;
		if(mode == 0){// i
			for (int i = 0; i < turns; i++){
				Forest forest = new Forest(20,20,p);
				if(forest.DepthFirstSearch()){
					count++;
				}
			}
		}
		else{
			for (int i = 0; i < turns; i++){
				Forest forest = new Forest(20,20,p);
				if(forest.BreadthFirstSearch()){
					count++;
				}
			}
		}
		return count/(double)turns;
	}
	
	//This calculates the highest level of vegetation that allows for about half of the tree to burn
	public static double highestVegitation(int mode){
		//Initializes the variables to do a binary search
		double min = 0;
		double max = 1;
		double p = 0;
		double forestBurn = 0;
		//This for WHILE loop looks until it finds a probability that is within .5%,
		//AS WAS REQUESTED BY PROF. ALBOW IN CLASS EVEN THOUGH THE PROPMT IMPLIES SOMETHING DIFFERENT
		while (!(forestBurn < .505 && forestBurn > .495)){
			p = (max + min) / 2.0;
			forestBurn = percentageOfBurn(p, mode);
			System.out.println(forestBurn+", " + p);
			if(forestBurn > 0.5){
				max = p;
			}
			else{
				min = p;
			}
		}
		return forestBurn;
	}
}
